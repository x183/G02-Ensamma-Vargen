package Entities;

public class Player extends ACharacter {
        double Armour;

        public Player(double Strength, double Health, double Armour, String Name){
                this.Strength = Strength;
                this.Health = Health;
                this.Armour = Armour;
                this.Name = Name;
        }

        public double getStrength(){
                return this.Strength;
        }

}
