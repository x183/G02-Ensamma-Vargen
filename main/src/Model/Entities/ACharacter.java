package Model.Entities;

import Model.Interfaces.ICharacter;

//Parent class to all the alive beings in the game
//All alive beings have a name, strength and health value
public abstract class ACharacter implements ICharacter {
        String Name;
        double Strength;
        double Health;

        public ACharacter(double Strength, double Health, String Name)
        {
                this.Strength = Strength;
                this.Health = Health;
                this.Name = Name;

        }
        //Getters for all attributes for alive beings
        public double getStrength(){
                return this.Strength;
        }
        public double getHealth(){
                return this.Health;
        }
        public String getName(){
                return this.Name;
        }
}
