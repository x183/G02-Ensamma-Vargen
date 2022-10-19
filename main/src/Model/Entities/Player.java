package Model.Entities;

//The actual person you play as in the game

/**
 * The Player class is the class that represents the player in the game. It extends the abstract class ACharacter
 */
public class Player extends ACharacter {

        /**
         * The constructor for the Player class
         */
        public Player(double Strength, double Health, double Armor, String Name)
        {
                super(Strength, Health, Name, Armor);

        }


}
