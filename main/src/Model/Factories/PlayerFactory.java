package Model.Factories;

import Model.Entities.Player;

/**
 * Player factory. Creates the premade classes and the custom made Player.
 */
public class PlayerFactory {
        public static Player createPlayer(double Strength, double Health, double Armour, String Name){
        return new Player(Strength, Health, Armour, Name);
        }
        public static Player createWarriorPlayer(String Name){
            return new Player(6, 4, 5, Name);
        }
        public static Player createHunterPlayer(String Name){
        return new Player(3, 2, 2, Name);
        }


}
