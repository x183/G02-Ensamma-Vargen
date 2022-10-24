package com.LoneWolf.Model.Interfaces;

import com.LoneWolf.Model.Entities.Player;
import com.LoneWolf.Model.Events.Event;

/**
 * Interface for the Action class, used to perform the actions the player chooses etc
 */
public interface IAction {
    void performAction(Player player);
    Event getNextEvent();
    String getActionName();
    String getPathToThisEvent();
}
