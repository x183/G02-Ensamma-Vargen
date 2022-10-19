package Model.Events.Actions;

import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;

import java.util.List;


/**
 * The Choice class, events have a list of choices, which are connected to actions.
 */
public class Choice implements IAction {
    private final String pathToThisEvent;
    private final String pathToNextEvent;
    private final String flavourText;
    private final List<IEffect> effects;

    /**
     * Creates a new choice
     * @param pathToThisEvent the path to this event
     * @param pathToNextScenario the path to the next event
     * @param flavourText the flavour text of the choice
     * @param effects the effects of the choice
     */
    public Choice(String pathToThisEvent, String pathToNextScenario, String flavourText, List<IEffect> effects) {
        this.pathToThisEvent = pathToThisEvent;
        this.pathToNextEvent = pathToNextScenario;
        this.flavourText = flavourText;
        this.effects = effects;
    }

    /**
     * performAction() performs the effect of the action of the choice on the player
     * @param player the player character
     */
    @Override
    public void performAction(Player player) {
            for(IEffect e : effects){
                e.apply(player);
            }
    }

    /**
     * getNextEvent() gets the next event
     * @return the next event
     */
    @Override
    public Event getNextEvent() {
        return Event.getEvent(pathToNextEvent);
    }

    /**
     * getActionName() gets the name of the action as a String
     * @return the name of the action as String
     */
    @Override
    public String getActionName() {
        return flavourText;
    }

    /**
     * getPathToThisEvent() gets the path to this event
     * @return the path to this event
     */
    @Override
    public String getPathToThisEvent() {
        return pathToThisEvent;
    }
}
