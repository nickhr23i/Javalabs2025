package org.example;

import javassist.CannotCompileException;
import javassist.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a class name as argument");
            return;
        }
        int totalTests = 0;
        int failedTests = 0;
        int passedTests = 0;
        File inputFile = new File(args[0]);
        if(inputFile.isFile()&&inputFile.getName().endsWith(".java")) {
            File outputDir = inputFile.getParentFile();
            if (!JavaCompilerUtil.compileJavaFiles(List.of(inputFile), outputDir)) {
                System.err.println("Compilation failed.");
                return;
            }
            inputFile=new File(outputDir, inputFile.getName().replace(".java", ".class"));
        }
        List<Class<?>> classes = getClasses(inputFile);
        for (Class<?> clazz : classes) {

            System.out.println("\n"+Modifier.toString(clazz.getModifiers())+" class " + clazz.getName());

            System.out.println("\nFields:");
            for(Field field : clazz.getDeclaredFields()) {
                System.out.println(Modifier.toString(field.getModifiers())+" "
                        + field.getType().getSimpleName() + " " + field.getName());
            }

            System.out.println("\nMethod Prototypes:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.print(Modifier.toString(method.getModifiers()) + " "
                        + method.getReturnType().getSimpleName() + " "
                        + method.getName() + "(");
                for(Parameter param : method.getParameters()) {
                    System.out.print(param.getType().getSimpleName() + " "+param.getName()+" ");
                }
                System.out.println(")");
            }

            System.out.println("\nRunning @Test methods:");
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {

                    System.out.println("Invoking: " + method.getName());
                    try {
                        method.setAccessible(true);
                        Object instance = null;
                        if (!Modifier.isStatic(method.getModifiers())) {
                            Constructor<?> ctor = clazz.getDeclaredConstructor();
                            ctor.setAccessible(true);
                            instance = ctor.newInstance();
                        }

                        Object[] params = generateMockParameters(method.getParameterTypes());
                        method.invoke(instance, params);
                        System.out.println("✓ " + method.getName());
                        passedTests++;
                    } catch (Exception e) {
                        System.out.println("✗ " + method.getName() + " failed: " + e.getCause());
                        failedTests++;
                    }
                }
            }
        }
        System.out.println("Total tests: " + totalTests);
        System.out.println("Failed tests: " + failedTests);
        System.out.println("Passed tests: " + passedTests);
        /*try {
            JavassistManipulation.example();
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/
    }

    public static List<Class<?>> getClasses(File inputFile) {
        List<Class<?>> classes = new ArrayList<>();
        String className;
        Path path, root;
        URLClassLoader loader;
        if (inputFile.exists()) {
            if (inputFile.isFile() && inputFile.getName().endsWith(".class")) {
                path = inputFile.toPath();
                root = path.getParent();
                className = inputFile.getName().replace(File.separator, ".").replace(".class", "");
                try {
                    loader = new URLClassLoader(new URL[]{root.toUri().toURL()}, ClassLoader.getSystemClassLoader());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    classes.add(loader.loadClass(className));
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not found: " + className);
                }
            } else if (inputFile.isDirectory()) {
                File[] files = inputFile.listFiles();
                path = inputFile.toPath();
                root = path;
                try {
                    loader = new URLClassLoader(new URL[]{root.toUri().toURL()}, ClassLoader.getSystemClassLoader());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".class")) {
                            className = file.getName().replace(File.separator, ".").replace(".class", "");
                            try {
                                classes.add(loader.loadClass(className));
                            } catch (ClassNotFoundException e) {
                                System.err.println("Class not found: " + className);
                            }
                        } else if (file.isDirectory()) {
                            classes.addAll(getClasses(file));
                        }
                    }
                }
            } else if (inputFile.getName().endsWith(".jar")) {
                try {
                    root = inputFile.toPath();
                    loader = new URLClassLoader(new URL[]{root.toUri().toURL()}, ClassLoader.getSystemClassLoader());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                try (JarFile jarFile = new JarFile(inputFile)) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry je = entries.nextElement();
                        if (je.getName().endsWith(".class")) {
                            className = je.getName().replace("/", ".").replace(".class", "");
                            System.out.println(className);
                            try {
                                classes.add(loader.loadClass(className));
                            } catch (ClassNotFoundException e) {
                                System.err.println("Class not found: " + className);
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return classes;
    }

    public static Object[] generateMockParameters(Class<?>[] paramTypes) {
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> p = paramTypes[i];
            if (p == int.class || p == Integer.class) params[i] = rand.nextInt(100);
            else if (p == boolean.class || p == Boolean.class) params[i] = rand.nextBoolean();
            else if (p == long.class || p == Long.class) params[i] = rand.nextLong();
            else if (p == double.class || p == Double.class) params[i] = rand.nextDouble();
            else if (p == float.class || p == Float.class) params[i] = rand.nextFloat();
            else if (p == char.class || p == Character.class) params[i] = (char) (rand.nextInt(26) + 'a');
            else if (p == byte.class || p == Byte.class) params[i] = (byte) rand.nextInt(128);
            else if (p == short.class || p == Short.class) params[i] = (short) rand.nextInt(1000);
            else if (p == String.class) params[i] = "mock" + rand.nextInt(1000);
            else params[i] = null;
        }
        return params;
    }
}