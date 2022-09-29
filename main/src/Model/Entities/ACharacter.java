package Model.Entities;

import Model.Interfaces.ICharacter;

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
