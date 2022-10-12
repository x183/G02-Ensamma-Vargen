package Model.Events.Actions;

import Model.Entities.CharacterState;
import Model.Entities.Creature;
import Model.Entities.Player;
import Model.Events.Event;
import Model.Interfaces.IAction;

//An event that occurs when the player is battling a creature
public class Battle implements IAction {
    private static String pretext = "Fight";
    private final String pathToNextEvent;
    private Creature enemy;
    private boolean playerWon;
    public Battle(String pathToNextEvent, Creature enemy){
        this.pathToNextEvent = pathToNextEvent;
        this.enemy = enemy;
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
        if (playerWon){
            return Event.getEvent(pathToNextEvent);
        }else {
            return Event.getGameOverEvent("Game over!" + enemy.getName()+ "killed you" );
        }
    }

    @Override
    public String getActionName()
    {
        return pretext + enemy.getName();
    }
}
