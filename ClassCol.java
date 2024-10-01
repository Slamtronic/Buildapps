package col;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class ClassCol {

    public static void main(String[] args) {
        String inputDir = "bin"; // Directory containing compiled .class files
        String outputJar = "colclass.jar"; // Output JAR file name

        try (JarOutputStream jos = new JarOutputStream(new FileOutputStream(outputJar))) {
            // Add all .class files from the specified directory
            addClassesToJar(inputDir, jos, inputDir.length() + 1);
            System.out.println("JAR file created successfully: " + outputJar);
        } catch (IOException e) {
            System.err.println("Error creating JAR file: " + e.getMessage());
        }
    }

    private static void addClassesToJar(String sourceDir, JarOutputStream jos, int basePathLength) throws IOException {
        File dir = new File(sourceDir);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively add classes from subdirectories
                    addClassesToJar(file.getPath(), jos, basePathLength);
                } else if (file.getName().endsWith(".class")) {
                    // Create a JarEntry for the class file
                    String entryName = file.getPath().substring(basePathLength).replace("\\", "/");
                    JarEntry entry = new JarEntry(entryName);
                    jos.putNextEntry(entry);
                    // Copy the class file content into the JAR
                    Files.copy(file.toPath(), jos);
                    jos.closeEntry();
                }
            }
        }
    }
}