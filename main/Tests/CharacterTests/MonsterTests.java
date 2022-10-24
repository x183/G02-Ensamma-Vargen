package CharacterTests;

import com.LoneWolf.Model.Entities.Creature;
import com.LoneWolf.Model.Factories.CreatureFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTests
{


    @Test
    public void testCreateRabbit()
    {
        Creature TestRabbit1 = CreatureFactory.createRabbit();
        assertEquals(1, TestRabbit1.getStrength(), 0.01);

    }
}

