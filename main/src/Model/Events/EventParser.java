package Model.Events;

import Model.Entities.Creature;
import Model.Events.Actions.Battle;
import Model.Events.Actions.Choice;
import Model.Factories.CreatureFactory;
import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses the event XML file and returns an Event object.
 */
public class EventParser {
    /**
     * Document parseDoc(String path)
     * parses xml file and returns a Document object
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
     * Parses the event node
     */
    public static Event parse(String eventPath) {
        Document doc = parseDoc(eventPath);

        Node eventNode = getEventNode(doc);
        NodeList eventChildren = eventNode.getChildNodes();
        String eventText = "Text wasn't initialized";
        List<IAction> eventActions = new ArrayList<>();
        for(int i = 0; i < eventChildren.getLength(); i++) {
            Node currentChildNode = eventChildren.item(i);
            switch (currentChildNode.getNodeName()) {
                case "text":  eventText = parseTextNode(currentChildNode, eventPath); break;
                case "actions": eventActions = parseActionsNode(currentChildNode, eventPath); break;
            }
        }
        return new Event(eventPath, eventText, eventActions);
    }

    /**
     * parses the actions node, the choices possible in the event and what they lead to
     * @param actionsNode the actions
     * @param eventPath the path to the event
     * @return a list of actions
     */
    private static List<IAction> parseActionsNode(Node actionsNode, String eventPath) {
        List<IAction> eventActions = new ArrayList<>();
        NodeList actionsChildren = actionsNode.getChildNodes();
        for (int i = 0; i < actionsChildren.getLength(); i++) {
            Node currentNode = actionsChildren.item(i);
            switch (currentNode.getNodeName()) {
                case "choice": {
                    NamedNodeMap attributes = currentNode.getAttributes();
                    String actionText = attributes.getNamedItem("name").getNodeValue();
                    String nextEventPath = attributes.getNamedItem("nexteventfile").getNodeValue();
                    List<IEffect> effects = new ArrayList<>();
                    NodeList choiceChildren = currentNode.getChildNodes();
                    for (int j = 0; j < choiceChildren.getLength(); j++) {
                        // TODO: parse effects
                    }

                    eventActions.add(new Choice(eventPath, nextEventPath, actionText, effects));
                    break;
                }
                case "battle": {
                    NamedNodeMap attributes = currentNode.getAttributes();
                    String actionText = attributes.getNamedItem("name").getNodeValue();
                    String nextEventPath = attributes.getNamedItem("nexteventfile").getNodeValue();
                    NodeList combatChildren = currentNode.getChildNodes();
                    Creature creature = null;
                    for (int j = 0; j < combatChildren.getLength(); j++) {
                        Node currentChild = combatChildren.item(j);
                        if (currentChild.getNodeName().equals("enemy")){
                            NamedNodeMap childAttributes = currentChild.getAttributes();
                            String name = childAttributes.getNamedItem("name").getNodeValue();
                            double strength = Double.parseDouble(childAttributes.getNamedItem("strength").getNodeValue());
                            double armor = Double.parseDouble(childAttributes.getNamedItem("armor").getNodeValue());
                            double health = Double.parseDouble(childAttributes.getNamedItem("health").getNodeValue());
                            boolean isHostile = Boolean.parseBoolean(childAttributes.getNamedItem("isHostile").getNodeValue());
                            creature = CreatureFactory.createMonster(isHostile, strength, health, armor, name);
                        }
                    }
                    if (creature == null) {
                        throw new RuntimeException("Creature not found for combat");
                    }
                    eventActions.add(new Battle(eventPath, nextEventPath, actionText, creature));
                    break;
                }
            }
        }
        return eventActions;
    }

    /**
     * parses the text node, the text of the event
     * @param textNode the text
     * @param eventPath the path to the event
     * @return the text of the event
     */
    private static String parseTextNode(Node textNode, String eventPath){return textNode.getTextContent();}
    /**
     * gets the event node
     * @param doc the document
     * @return the event node
     */
    private static Node getEventNode(Document doc){return doc.getElementsByTagName("event").item(0);}
}
