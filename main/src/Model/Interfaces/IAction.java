package Model.Interfaces;

import Model.Entities.Player;
import Model.Events.Event;

/**
 * Interface for the Action class, used to perform the actions the player chooses etc
 */
public interface IAction {
    void performAction(Player player);
    Event getNextEvent();
    String getActionName();
    String getPathToThisEvent();
}
