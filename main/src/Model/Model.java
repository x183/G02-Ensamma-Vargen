package Model;

import Model.Entities.CharacterState;
import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;
import Model.Interfaces.util.IObservable;
import Model.Interfaces.util.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Model implements IObserver<IAction>, IObservable<Event> {
    //private static Model instance = null;
    private final List<IObserver<Event>> observers;
    private final Player player;
    private Event currentEvent;

    public Model(Player player, Event firstEvent){
        this.player = player;
        this.observers = new ArrayList<>();
        this.currentEvent = firstEvent;
        currentEvent.subscribe(this);
    }

    public double getPlayerStrength(){
        return player.getStrength();
    }
    public double getPlayerArmour(){
        return player.getArmor();
    }

   /* public static Model getInstance(){
        if (instance == null) {
            instance = new Model();
            instance.init();
        }
        return instance;
        return null;
    } */


    public void shutDown(){

    }

    @Override
    public void subscribe(IObserver<Event> observer) {
        observers.add(observer);
        notifyObservers(currentEvent);
    }

    @Override
    public void notifyObservers(Event event) {
        for (IObserver<Event> o : observers) {
            o.update(event);
        }
    }

    @Override
    public void update(IAction action) {
        action.performAction(player);
        currentEvent = action.getNextEvent();
        currentEvent.subscribe(this);
        notifyObservers(currentEvent);
    }

    public void selectAction(int i){
        currentEvent.selectAction(i);
    }
    public String getActionName(int i){return currentEvent.getActionText(i);}

    public Event getCurrentEvent()
    {
        return currentEvent;
    }

}
