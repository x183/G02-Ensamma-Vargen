import Entities.Monster;
import org.junit.Test;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTests
{
    Monster TestRabbit1 = Factories.CreatureFactory.createRabbit();
    Monster TestRabbit2 = Factories.CreatureFactory.createRabbit();

    @Test
    public void test()
    {
        assertEquals(1, TestRabbit1.getHealth());
        assertEquals(0, this.TestRabbit2.getArmour());

    }
}

