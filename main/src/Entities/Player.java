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
        public double getHealth(){
                return this.Health;
        }
        public double getArmour(){
                return this.Armour;
        }
        public String getName(){
                return this.Name;
        }

}
