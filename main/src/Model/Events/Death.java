package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;

import java.util.ArrayList;
import java.util.List;

//An event where a choice you have made killed you, or you lost a battle
public class Death extends Event
{

    protected Death(String eventText, List<IAction> actions) {
        super(eventText, actions);

    }
}
