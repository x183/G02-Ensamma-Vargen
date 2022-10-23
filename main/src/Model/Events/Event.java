package Model.Events;

import Model.Interfaces.IAction;
import Model.Interfaces.util.IObservable;
import Model.Interfaces.util.IObserver;

import java.util.ArrayList;
import java.util.List;


/**
 * The event class, we create events from XML files using a parser
 */
public class Event extends EventSuper implements IObservable<IAction> {
    private final List<IObserver<IAction>> observers;
    private final String pathToThisEvent;

    /**
     * returns the list of actions possible in this event
     * @return list of actions
     */
    public List<IAction> getActions() {
        return actions;
    }

    private final List<IAction> actions;

    /**
     * Creates a new event
     * @param eventText the text of the event
     * @param actions the actions of the event
     * private pathToThisEvent the path to this event
     */
    protected Event(String thisEventPath, String eventText, List<IAction> actions) {
        pathToThisEvent = thisEventPath;
        observers = new ArrayList<>();
        this.eventText = eventText;
        this.actions = actions;
    }

    /**
     * getEvent, gets the event by calling on the parser
     * @param eventPath the path to the XML file
     * @return the event
     */
    public static Event getEvent(String eventPath){
        return EventParser.parse(eventPath);
    }

    /**
     * selectAction(int i) selects the action at index i
     * @param i index
     */
    public void selectAction(int i){
        if(i >= actions.size() | i < 0){
            throw new RuntimeException("Selected index not in range");
        }
        notifyObservers(actions.get(i));
    }

    /**
     * notify observers
     * @param action the action
     */
    @Override
    public void notifyObservers(IAction action) {
        for (IObserver<IAction> o : observers) {
            o.update(action);
        }
    }

    /**
     * add observer, making them subscribe
     * @param observer the observer
     */
    @Override
    public void subscribe(IObserver<IAction> observer) {
        observers.add(observer);
    }

    /**
     * gets the action text of the event
     * @param i index of action
     * @return string of text from event
     */
    public String getActionText(int i){
        return actions.get(i).getActionName();
    }

    /**
     * gets the amount of actions of this event
     * @return size of actions list
     */
    public int getAmountOfActions(){
        return actions.size();
    }

    /**
     * getEventText, gets the text of the event
     * @return string eventText
     */
    public String getEventText(){
        return eventText;
    }


    /**
     * getPathToThisEvent, gets the path to this event
     * @return the path to this event
     */
    public String getPathToThisEvent() {
        return pathToThisEvent;
    }
}
