package Model.Entities;

/**
 * The Creature class is the class that represents the creatures, NPCs, in the game. It extends the abstract class ACharacter
 */
public class Creature extends ACharacter{
    /**
     * boolean isHostile, if true the npc is a hostile enemy
     */
    boolean isHostile;
    /**
     * The constructor for the Creature class
     */
    public Creature(boolean isHostile, double Strength, double Health, String Name, double Armour) {
        super(Strength, Health, Name, Armour);

        this.isHostile = isHostile;
    }


}

