package Model.Entities;


public class Creature extends ACharacter{
//Boolean to decide if a creature is hostile or not
// For example, an orc should be hostile by default but a rabbit shouldn't
    boolean isHostile;
// Creatures are all non-playable characters
    public Creature(boolean isHostile, double Strength, double Health, String Name, double Armour) {
        super(Strength, Health, Name, Armour);

        this.isHostile = isHostile;
    }


}

