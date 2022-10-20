package Model.Entities;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ACharacterTest {

    @Test
    public void addHealth() {
        ACharacter testCharacter = new ACharacter(1,1,"fi", 1);
        testCharacter.addHealth(1);
        assertEquals(2, testCharacter.getCurrentHealth());
    }

    @Test
    public void removeHealth() {
        ACharacter testCharacter = new ACharacter(1,1,"fi", 1);
        testCharacter.removeHealth(1);
        assertEquals(0, testCharacter.getCurrentHealth());
    }

    @Test
    public void isAlive() {
        ACharacter testCharacter = new ACharacter(1,1,"fi", 1);
        assertTrue(testCharacter.isAlive());
        testCharacter.removeHealth(1);
        assertFalse(testCharacter.isAlive());
    }

    @Test
    public void testperformAction() {
        ACharacter testCharacter = new ACharacter(1,1,"fi", 1);
        testCharacter.performAction();
    }

}