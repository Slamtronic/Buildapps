import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CredFile {
    public static void main(String[] args) {
        // Specify the directory and file names
        String directoryName = "my_directory";
        String fileName = "file.xml";

        // Create the directory
        File directory = new File(directoryName);
        if (!directory.exists()) {
            boolean dirCreated = directory.mkdir(); // Create the directory
            if (dirCreated) {
                System.out.println("Directory created: " + directoryName);
            } else {
                System.out.println("Failed to create directory: " + directoryName);
                return;
            }
        }

        // Create the XML file in the directory
        File xmlFile = new File(directory, fileName);
        try (FileWriter writer = new FileWriter(xmlFile)) {
            // Write some XML data to the file
            writer.write("<root>\n");
            writer.write("    <element>Sample Data</element>\n");
            writer.write("</root>\n");
            System.out.println("File created and data written: " + xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}