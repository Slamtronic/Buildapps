package pac;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.List;
import java.io.*;
import java.util.jar.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Jacon{
	    
		static String inputDir = "bin"; // Directory containing compiled .class files
        static String outputJar = "colclass.jar"; // Output JAR file name
        static String manicon="";
		static String attributeName = "Main-Class"; // Replace with your attribute name
        static  String manifestFileName = "manifest.txt";
		static String className ="";//to be used
	
    public static void main(String[] args) {
		
		getmanicon();
		
		
		
		
}
public static void getmanicon(){

 Path filePath = Paths.get("manifest.txt"); // Specify the path to your file

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(filePath);
            
            // Print each line
            for (String line : lines) {
                //System.out.println(line);
				manicon=manicon+line+"\n" ;
            }
			getBin();
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IO exceptions
        }

}

public static void getBin(){
	
	//String jarFileName = "jaro.jar";
            try (JarOutputStream jos = new JarOutputStream(new FileOutputStream(outputJar))) {
                // Add manifest
                JarEntry manifestEntry = new JarEntry("META-INF/");
                jos.putNextEntry(manifestEntry);
                jos.closeEntry();

                // Add the manifest file
                JarEntry jarEntry = new JarEntry("META-INF/MANIFEST.MF");
                jos.putNextEntry(jarEntry);
                jos.write(manicon.getBytes());
                jos.closeEntry();

                // Add the compiled class
				
				addClassesToJar(inputDir, jos, inputDir.length() + 1);
            System.out.println("JAR file created successfully: " + outputJar);
				
				
               ////////
            }
    catch (IOException ee) {
            ee.printStackTrace();
        }
            // Step 5: Clean up
            //Files.delete(javaFile);
            //Files.delete(manifestFile);
            //Files.delete(Paths.get(className + ".class"));
	
}

   private static void addClassesToJar(String sourceDir, JarOutputStream jos, int basePathLength) 
	throws IOException {
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

}//CLASS8/MAIN
