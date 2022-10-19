package Model.Events.Actions;

import Model.Entities.CharacterState;
import Model.Entities.Creature;
import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;

/**
 * The Battle class, an event that occurs when the player is battling a creature
 */
public class Battle implements IAction {
    private final String pathToThisEvent;
    private static String pretext = " Fight";
    private final String pathToNextEvent;
    private Creature enemy;
    private String flavourText;
    private boolean playerWon;

    /**
     * Creates a new battle
     * @param pathToThisEvent the path to this event
     * @param pathToNextEvent the path to the next event
     * @param enemy the enemy creature
     * @param flavourText the flavour text of the battle
     */
    public Battle(String pathToThisEvent, String pathToNextEvent, String flavourText, Creature enemy){
        this.pathToThisEvent = pathToThisEvent;
        this.pathToNextEvent = pathToNextEvent;
        this.enemy = enemy;
        this.flavourText = flavourText;
        playerWon = false;
    }

    /**
     * evaluateBattle() evaluates the battle between player and enemy
     * @param player the current player
     */
    private void evaluateBattle(Player player){
        double enemyDmgTakenPerRound = Math.max(player.getStrength()-enemy.getArmor(), 0);
        double playerDmgTakenPerRound = Math.max(enemy.getStrength()-player.getArmor(), 0);

        while (player.isAlive() & enemy.isAlive()){
            player.removeHealth(playerDmgTakenPerRound);
            enemy.removeHealth(enemyDmgTakenPerRound);
        }
    }


    /**
     * performs the battle action and checks who survived
     */
    @Override
    public void performAction(Player player) {
        evaluateBattle(player);
        playerWon = player.isAlive();

    }

    /**
     * getNextEvent() gets the next event
     * if the enemy name is " reaper" the player has died from natural/unavoidable causes and the game is over. in these
     * cases the player is sent to a unique event that explains what happened to them, i.e "you fell off a cliff and died"
     * @return the next event
     */
    @Override
    public Event getNextEvent()
    {
        if(enemy.getName().equals(" reaper")|playerWon){
            return Event.getEvent(pathToNextEvent);
        } else {
            return Event.getEvent("assets/AllEvents/deathEvent.xml");
        }

    }

    /**
     * getActionName() gets the name of the action as a String
     * @return the name of the action as String
     */
    @Override
    public String getActionName()
    {
        return flavourText;
    }
    /**
     * getPathToThisEvent() gets this event's path
     * @return the event's path as a String
     */
    @Override
    public String getPathToThisEvent() {
        return pathToThisEvent;
    }
}
