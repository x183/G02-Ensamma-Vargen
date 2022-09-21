import Entities.Player;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
        Player testPlayer = new Player(2,2,2, "Stocken");

        @Test
        public void test(){
            assertEquals(2, testPlayer.getStrength());
        }

}
