package Model.Events.Actions;

import Model.Entities.CharacterState;
import Model.Entities.Creature;
import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;

//An event that occurs when the player is battling a creature
public class Battle implements IAction {
    private static String pretext = " Fight";
    private final String pathToNextEvent;
    private Creature enemy;
    private String flavourText;
    private boolean playerWon;

    public Battle(String pathToNextEvent, String flavourText, Creature enemy){
        this.pathToNextEvent = pathToNextEvent;
        this.enemy = enemy;
        this.flavourText = flavourText;
        playerWon = false;
    }

    private void evaluateBattle(Player player){
        double enemyDmgTakenPerRound = Math.max(player.getStrength()-enemy.getArmor(), 0);
        double playerDmgTakenPerRound = Math.max(enemy.getStrength()-player.getArmor(), 0);

        while (player.isAlive() & enemy.isAlive()){
            player.removeHealth(playerDmgTakenPerRound);
            enemy.removeHealth(enemyDmgTakenPerRound);
        }
    }


    @Override
    public void performAction(Player player) {
        evaluateBattle(player);
        playerWon = player.isAlive();

    }

    @Override
    public Event getNextEvent()
    {
        if(enemy.getName().equals(" reaper")|playerWon){
            return Event.getEvent(pathToNextEvent);
        } else {
            return Event.getEvent("assets/AllEvents/deathEvent.xml");
        }

    }

    @Override
    public String getActionName()
    {
        return flavourText;
    }
}
