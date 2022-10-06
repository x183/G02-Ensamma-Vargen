package Model.Entities;

import Model.Interfaces.ICharacter;

//Parent class to all the alive beings in the game
//All alive beings have a name, strength, armor and health value, both max and current
public class ACharacter implements ICharacter {
        String Name;
        double Strength;
        double maxHealth;
        double currentHealth;
        double Armor;

        public ACharacter(double Strength, double Health, String Name, double Armor)
        {
                this.Strength = Strength;
                this.maxHealth = Health;
                this.currentHealth = Health;
                this.Name = Name;
                this.Armor = Armor;


        }
        public void addToHealth(double value)
        {
                currentHealth += value;
                currentHealth = Math.min(Math.max(currentHealth, 0), maxHealth);
        }
        //Boolean for if a character is alive or not
        public boolean isAlive()
        {
                return currentHealth > 0;
        }

        //Getters for all attributes for characters
        public double getStrength()
        {
                return this.Strength;
        }
        public double getmaxHealth()
        {
                return this.maxHealth;
        }
        public double getCurrentHealth()
        {
                return this.currentHealth;
        }
        public String getName()
        {
                return this.Name;
        }
        public double getArmor()
        {
                return this.Armor;
        }

}
