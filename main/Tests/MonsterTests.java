import Model.Entities.Creature;
import Model.Factories.CreatureFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTests
{
    Creature TestRabbit1 = CreatureFactory.createRabbit();
    Creature TestRabbit2 = CreatureFactory.createRabbit();

    @Test
    public void test()
    {
        assertEquals(1, TestRabbit1.getmaxHealth());
        //assertEquals(0, this.TestRabbit2.getArmour());

    }
}

