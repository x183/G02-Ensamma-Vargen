package Model.Events.Actions;

import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;

import java.util.List;

//An event that occurs when the player has to make a choice to move to the next event
public class Choice implements IAction {
    private final String pathToNextEvent;
    private final String flavourText;
    private final List<IEffect> effects;

    public Choice(String pathToNextScenario, String flavourText, List<IEffect> effects) {
        this.pathToNextEvent = pathToNextScenario;
        this.flavourText = flavourText;
        this.effects = effects;
    }

    @Override
    public void performAction(Player player) {
            for(IEffect e : effects){
                e.apply(player);
            }
    }

    @Override
    public Event getNextEvent() {
        return Event.getEvent(pathToNextEvent);
    }

    @Override
    public String getActionName() {
        return flavourText;
    }
}
