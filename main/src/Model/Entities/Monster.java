package Model.Entities;

public class Monster extends Creature {
            double Armour;
    public Monster(double Strength, double Health, double Armour, String Name)
    {
        super(Strength, Health, Name);
            this.Armour = Armour;


    }


    public double getArmour() {return this.Armour;}

}
