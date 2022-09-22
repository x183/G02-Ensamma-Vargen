import Entities.Monster;
import Entities.Player;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
        Player testPlayer1 = new Player(2,2,2, "Stocken");
        Player testPlayer2 = Factories.PlayerFactory.createPlayer(3, 4, 5, "Pixie");



    @Test
        public void test(){
            assertEquals(2, testPlayer1.getStrength());
            assertEquals(4, testPlayer2.getHealth());
        }




}
