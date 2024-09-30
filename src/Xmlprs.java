package xml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class Xmlprs {

    public static void main(String[] args) {
        try {
            // Specify the path to the XML file
            File xmlFile = new File("lib/example.xml");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file and get the document
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get all parent elements (in this case, just "Parent")
            NodeList parentNodes = doc.getElementsByTagName("*");

            // Loop through all nodes
            for (int i = 0; i < parentNodes.getLength(); i++) {
                Node node = parentNodes.item(i);

                // Check if the node is an element node
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Print the element name and its attributes
                    System.out.println("Element: " + element.getNodeName());
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        System.out.println("  Attribute: " + element.getAttributes().item(j).getNodeName() +
                                           " = " + element.getAttributes().item(j).getNodeValue());
                    }

                    // Print children elements
                    NodeList childNodes = element.getChildNodes();
                    for (int k = 0; k < childNodes.getLength(); k++) {
                        Node childNode = childNodes.item(k);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNode;
                            System.out.println("  Child Element: " + childElement.getNodeName());
                            for (int l = 0; l < childElement.getAttributes().getLength(); l++) {
                                System.out.println("    Child Attribute: " + childElement.getAttributes().item(l).getNodeName() +
                                                   " = " + childElement.getAttributes().item(l).getNodeValue());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
			System.out.println("Element: issue with xml f \n"+e);
           // e.printStackTrace();
        }
    }
}