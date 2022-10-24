package com.LoneWolf.Model;

import com.LoneWolf.Model.Entities.Player;
import com.LoneWolf.Model.Events.Event;
import com.LoneWolf.Model.Interfaces.IAction;
import com.LoneWolf.Model.Interfaces.util.IObservable;
import com.LoneWolf.Model.Interfaces.util.IObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model of the game. The model is the part of the game that holds all the data and logic.
 * The model is the only part of the game that can change the state of the game.
 * It implements the observer pattern so that the view can subscribe to the model and get notified when the model changes.
 */
public class Model implements IObserver<IAction>, IObservable<Event> {
    private final List<IObserver<Event>> observers;
    private Player player;
    private final Player playerBackup;
    private Event currentEvent;
    /**
     * The model that is initialized through NewGameController
     */
    public static Model gameModel;

    /**
     * Constructor of the Model
     * @param player the player character of the game
     * @param firstEvent the first event of the game
     */
    public Model(Player player, Event firstEvent){
        this.player = player;
        this.playerBackup = player;
        this.observers = new ArrayList<>();
        this.currentEvent = firstEvent;
        currentEvent.subscribe(this);
    }

    public static void setGameModel(Model gameModel) {
        Model.gameModel = gameModel;
    }
    public double getPlayerStrength(){
        return player.getStrength();
    }
    public double getPlayerArmour(){
        return player.getArmor();
    }
    public double getPlayerHealth(){
        return player.getmaxHealth();
    }
    public String getPlayerName(){
        return player.getName();
    }

    /**
     * Resets the player to its starting value (used when player dies and wants to restart)
     */
    public void resetPlayer(){
        this.player = playerBackup;
       // System.out.println(player.getCurrentHealth());
    }

    /**
     * used to get an instance of the Model
     * @return returns the instance of the model
     */
    public static Model getInstance(){
        if (gameModel == null) {
            System.out.println("Model not found, quitting");
            System.exit(1);
        }
        return gameModel;
    }


    public void shutDown(){

    }

    /**
     * subscribe method
     * @param observer the subscriber
     */
    @Override
    public void subscribe(IObserver<Event> observer) {
        observers.add(observer);
        notifyObservers(currentEvent);
    }

    /**
     * notify method for nootifying the subscribers
     * @param event the event
     */
    @Override
    public void notifyObservers(Event event) {
        for (IObserver<Event> o : observers) {
            o.update(event);
        }
    }

    /**
     * update method with choice player has made
     * @param action choice player has made
     */
    @Override
    public void update(IAction action) {
       // System.out.println(player.getCurrentHealth());
        action.performAction(player);
        currentEvent = action.getNextEvent();
        currentEvent.subscribe(this);
        notifyObservers(currentEvent);
    }

    /**
     * Select action. Method used when player selects an action in an event
     * @param i index of the action
     */
    public void selectAction(int i){
        currentEvent.selectAction(i);
    }
    public String getActionName(int i){return currentEvent.getActionText(i);}

    public Event getCurrentEvent()
    {
        return currentEvent;
    }

}
