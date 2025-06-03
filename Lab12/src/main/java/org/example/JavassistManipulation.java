package org.example;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

public class JavassistManipulation {
    private JavassistManipulation() {}
    public static void example() throws NotFoundException, CannotCompileException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassPool pool = ClassPool.getDefault();

        pool.insertClassPath(new ClassClassPath(TargetClass.class));

        CtClass ctClass = pool.get("org.example.TargetClass");

        CtMethod method = ctClass.getDeclaredMethod("nonStaticTest");

        method.insertBefore("System.out.println(\"Hello World\");");
        Class<?> modifiedClass = ctClass.toClass(TargetClass.class.getClassLoader(),TargetClass.class.getProtectionDomain());

        Object instance = modifiedClass.getDeclaredConstructor().newInstance();
        Method m = modifiedClass.getMethod("nonStaticTest");
        m.invoke(instance);
    }
}
