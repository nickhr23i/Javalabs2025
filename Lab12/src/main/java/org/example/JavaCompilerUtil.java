package org.example;

import javax.tools.*;
import java.io.File;
import java.util.List;
import java.util.Arrays;

public class JavaCompilerUtil {
    private JavaCompilerUtil() {}

    public static boolean compileJavaFiles(List<File> javaFiles, File outputDir) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException("No system Java compiler available. Are you using a JRE instead of a JDK?");
        }

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(javaFiles);

        List<String> options = Arrays.asList("-d", outputDir.getAbsolutePath(), "-parameters");

        JavaCompiler.CompilationTask task = compiler.getTask(
                null, fileManager, null, options, null, compilationUnits
        );

        boolean success = task.call();
        try {
            fileManager.close();
        } catch (Exception ignored) {}
        return success;
    }
}
