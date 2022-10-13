package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;

import java.util.ArrayList;
import java.util.List;

//An event where a choice you have made killed you, or you lost a battle
public class DeathEvent extends Event {

    protected DeathEvent(String eventText, List<IAction> actions) {
        super(eventText, actions);

    }
}
