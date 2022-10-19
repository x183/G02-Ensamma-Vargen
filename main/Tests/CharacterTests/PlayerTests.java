package CharacterTests;

import Model.Entities.Player;
import Model.Factories.PlayerFactory;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
        Player testPlayer1 = new Player(2,2,2, "Stocken");
        Player testPlayer2 = PlayerFactory.createPlayer(3, 4, 5, "Pixie");



    @Test
        public void test(){
            assertEquals(2, testPlayer1.getStrength());
            assertEquals(4, testPlayer2.getmaxHealth());
        }




}
