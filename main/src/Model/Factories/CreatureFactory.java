package Model.Factories;

import Model.Entities.Creature;

public class CreatureFactory
{
    public static Creature createMonster(boolean isHostile, double Strength, double Health, double Armour, String Name)
    {
        return new Creature(isHostile, Strength, Health, Name, Armour);

    }
        public static Creature createRabbit()
        {
            return new Creature(false, 1, 0, "Rabbit", 0);
        }
        public static Creature createOrc()
        {
            return new Creature(true,4,2,"Orc", 4);
        }

}
