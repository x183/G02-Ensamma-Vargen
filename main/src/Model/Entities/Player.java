package Model.Entities;

//The actual person you play as in the game, has an armour value
public class Player extends ACharacter {
        double Armour;

        public Player(double Strength, double Health, double Armour, String Name){
                super(Strength,Health, Name);

                this.Armour = Armour;

        }
        //Getter for armour
        public double getArmour(){
                return this.Armour;
        }


}
