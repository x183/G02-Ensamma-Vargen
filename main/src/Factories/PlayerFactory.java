package Factories;

import Entities.Player;

public class PlayerFactory {
        public static Player createPlayer(double Strength, double Health, double Armour, String Name){
        return new Player(Strength, Health, Armour, Name);
    }


}
