package Model.Entities;

//An evil kind of creature, has an armour value
public class Monster extends Creature {
            double Armour;
    public Monster(double Strength, double Health, double Armour, String Name)
    {
        super(Strength, Health, Name);
            this.Armour = Armour;


    }

    //Getter for armour
    public double getArmour() {return this.Armour;}

}
