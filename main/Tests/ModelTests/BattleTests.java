package ModelTests;

import Model.Entities.Creature;
import Model.Entities.Player;
import Model.Events.Actions.Battle;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTests {
        Player testPlayer1 = new Player(4,3,2, "Stocken");
        Creature testMonsterStrong = new Creature(true, 6,6,"Orc", 6);
        Creature testMonsterWeak = new Creature(true, 1,1,"Rabbit", 1);
        String testThisEvent = "assets/AllEvents/TestEvent1.xml";
        String testNextEvent = "assets/AllEvents/TestEvent1.xml";

        @Test
        public void testBattleWon(){
            Battle testBattle = new Battle(testThisEvent, testNextEvent, "TestBattleWon", testMonsterWeak);
            testBattle.performAction(testPlayer1);
            assertTrue(testBattle.getPlayerWon());
            assertFalse(testMonsterWeak.isAlive());
        }

        @Test
        public void testBattleLost(){
            Battle testBattle = new Battle(testThisEvent, testNextEvent, "TestBattleLost", testMonsterStrong);
            testBattle.performAction(testPlayer1);
            assertEquals(0, testPlayer1.getCurrentHealth());
            assertFalse(testBattle.getPlayerWon());
        }
}
