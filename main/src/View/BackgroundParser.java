package View;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Parses the background XML file and returns a Background object.
 */
public class BackgroundParser {
    /**
     * Parses the background XML file and returns a Background object.
     * @param path The path to the background XML file.
     * @return A Background object.
     */
    private static Document parseDoc(String path) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            // TODO: Handle exception
            throw new RuntimeException();
        }
    }
    /**
     * Gets event node from the XML file.
     */
    private static Node getEventNode(Document doc){return doc.getElementsByTagName("event").item(0);}

    /**
     * Parses the image node and returns the path to the image.
     */
    public static Background ParseBackground(String pathToEvent) {
        Document doc = parseDoc(pathToEvent);
        Node eventNode = getEventNode(doc);
        NamedNodeMap eventNodeAttributes = eventNode.getAttributes();
        try{
            String pathToImage = eventNodeAttributes.getNamedItem("background").getNodeValue();
            System.out.println(pathToImage);
            return new Background(new BackgroundImage(
                    new Image(System.getProperty("user.dir") + "/" + pathToImage),
                    null,
                    null,
                    null,
                    null));
        } catch (Exception e) {
            throw new RuntimeException("Couldn't find image path of " + pathToEvent);
        }
    }
}
