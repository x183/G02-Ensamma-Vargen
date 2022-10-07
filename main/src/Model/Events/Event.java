package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.util.IObservable;
import Model.Interfaces.util.IObserver;

import java.util.ArrayList;
import java.util.List;

//The forrest represent all the events that can happen.
//The forrest has graph containing all events and how they relate to echother
public class Event implements IObservable<IAction> {
    private final List<IObserver<IAction>> observers;
    private final List<IAction> actions;
    private final String eventText;

    protected Event(String eventText, List<IAction> actions){
        observers = new ArrayList<>();
        this.eventText = eventText;
        this.actions = actions;
    }
    public static Event getEvent(String eventPath){
        return EventParser.parse(eventPath);
    }

    @Override
    public void notifyObservers(IAction action) {
        for (IObserver<IAction> o : observers) {
            o.update(action);
        }
    }

    @Override
    public void subscribe(IObserver<IAction> observer) {
        observers.add(observer);
    }
}
