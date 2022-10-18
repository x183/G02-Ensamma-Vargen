package Model.Interfaces;

import Model.Entities.Player;
import Model.Events.Event;

public interface IAction {
    void performAction(Player player);
    Event getNextEvent();
    String getActionName();
    String getPathToThisEvent();
}
