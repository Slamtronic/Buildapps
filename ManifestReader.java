package read;
import java.io.*;
import java.util.jar.*;

public class ManifestReader {
    public static void main(String[] args) {
        // Name of the attribute to retrieve from the manifest
        String attributeName = "ATTRB"; // Replace with your attribute name
        String manifestFileName = "manifest.txt";

        try {
            // Load the manifest file
            FileInputStream fis = new FileInputStream(manifestFileName);
            Manifest manifest = new Manifest(fis);

            // Retrieve the attribute value
            String attributeValue = manifest.getMainAttributes().getValue(attributeName);
            
            // Check if the attribute exists
            if (attributeValue != null) {
                System.out.println("Value of " + attributeName + ": " + attributeValue);
            } else {
                System.out.println("Attribute " + attributeName + " not found in manifest.");
            }

            fis.close();
        } catch (IOException e) {
            System.err.println("Error reading the manifest file: " + e.getMessage());
        }
    }
}