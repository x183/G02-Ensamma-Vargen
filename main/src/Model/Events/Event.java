package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.util.IObservable;
import Model.Interfaces.util.IObserver;

import java.util.ArrayList;
import java.util.List;

//The forrest represent all the events that can happen.
//The forrest has graph containing all events and how they relate to eachother
public class Event extends EventSuper implements IObservable<IAction> {
    private final List<IObserver<IAction>> observers;

    public List<IAction> getActions() {
        return actions;
    }

    private final List<IAction> actions;

    protected Event(String eventText, List<IAction> actions){
        observers = new ArrayList<>();
        this.eventText = eventText;
        this.actions = actions;
    }
    public static Event getEvent(String eventPath){
        return EventParser.parse(eventPath);
    }

    public void selectAction(int i){
        if(i >= actions.size() | i < 0){
            throw new RuntimeException("Selected index not in range");
        }
        notifyObservers(actions.get(i));
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

    public String getActionText(int i){
        return actions.get(i).getActionName();
    }
    public int getAmountOfActions(){
        return actions.size();
    }
    public String getEventText(){
        return eventText;
    }
    public static Event getGameOverEvent(String message){
        return new Event(message, new ArrayList<>());
    }

}
