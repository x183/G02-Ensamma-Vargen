package Factories;

import Entities.Monster;

public class CreatureFactory
{
    public static Monster createMonster(double Strength, double Health, double Armour, String Name)
    {
        return new Monster(Strength, Health, Armour, Name);

    }
        public static Monster createRabbit()
        {
            return new Monster(1, 1, 0, "Rabbit");
        }

}
