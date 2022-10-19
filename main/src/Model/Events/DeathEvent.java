package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.IEffect;

import java.util.ArrayList;
import java.util.List;


/**
 * The death event, currently not used, instead deathEvent has been implemented as an XML file
 */
public class DeathEvent extends Event {

    protected DeathEvent(String pathToThisEvent, String eventText, List<IAction> actions) {
        super(pathToThisEvent, eventText, actions);

    }
}
