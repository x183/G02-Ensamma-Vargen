package Model.Entities;

public class Player extends ACharacter {
        double Armour;

        public Player(double Strength, double Health, double Armour, String Name){
                super(Strength,Health, Name);

                this.Armour = Armour;

        }

        public double getArmour(){
                return this.Armour;
        }


}
