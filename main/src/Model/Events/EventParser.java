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

public class EventParser {
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
    public static Event parse(String eventPath) {
        Document doc = parseDoc(eventPath);

        Node eventNode = getEventNode(doc);
        NodeList eventChildren = eventNode.getChildNodes();
        String eventText = "Text wasn't initialized";
        List<IAction> eventActions = new ArrayList<>();
        for(int i = 0; i < eventChildren.getLength(); i++) {
            Node currentChildNode = eventChildren.item(i);
            switch (currentChildNode.getNodeName()) {
                case "text":  eventText = parseTextNode(currentChildNode); break;
                case "actions": eventActions = parseActionsNode(currentChildNode); break;
            }
        }
        return new Event(eventText, eventActions);
    }
    private static List<IAction> parseActionsNode(Node actionsNode) {
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

                    eventActions.add(new Choice(nextEventPath, actionText, effects));
                    break;
                }
                case "combat": {
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
                            double str = Double.parseDouble(childAttributes.getNamedItem("strength").getNodeValue());
                            double armor = Double.parseDouble(childAttributes.getNamedItem("armor").getNodeValue());
                            double hp = Double.parseDouble(childAttributes.getNamedItem("health").getNodeValue());
                            boolean isHostile = Boolean.parseBoolean(childAttributes.getNamedItem("isHostile").getNodeValue());
                           // wrong place- boolean resultsInDeath = Boolean.parseBoolean(childAttributes.getNamedItem("resultsInDeath").getNodeValue());
                           // creature = new Creature(name, isHostile, hp, str, armor);
                            creature = CreatureFactory.createMonster(isHostile, str, hp, armor, name);
                        }
                    }
                    if (creature == null) {
                        throw new RuntimeException("Creature not found for combat");
                    }
                    eventActions.add(new Battle(nextEventPath, actionText, creature));
                    break;
                }
            }
        }
        return eventActions;
    }
    private static String parseTextNode(Node textNode){return textNode.getTextContent();}
    private static Node getEventNode(Document doc){return doc.getElementsByTagName("event").item(0);}
}
