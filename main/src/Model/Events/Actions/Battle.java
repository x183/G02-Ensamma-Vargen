package Model.Events.Actions;

import Model.Entities.Player;
import Model.Events.Event;
import Model.Events.Events;
import Model.Interfaces.IAction;

//An event that occurs when the player is battling a creature
public class Battle implements IAction {
    @Override
    public void performAction(Player player) {

    }

    @Override
    public Event getNextEvent() {
        return null;
    }

    @Override
    public String getActionName() {
        return null;
    }
}
