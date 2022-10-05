package Model.Entities;

import Model.Interfaces.ICharacter;

//Parent class to all the alive beings in the game
//All alive beings have a name, strength and health value
public class ACharacter implements ICharacter {
        String Name;
        double Strength;
        double maxHealth;
        double currentHealth;

        public ACharacter(double Strength, double Health, String Name)
        {
                this.Strength = Strength;
                this.maxHealth = Health;
                this.currentHealth = Health;
                this.Name = Name;

        }
        public void addToHealth(double value)
        {
                currentHealth += value;
                currentHealth = Math.min(Math.max(currentHealth, 0), maxHealth);
        }

        public boolean isAlive()
        {
                return currentHealth > 0;
        }
        //Getters for all attributes for alive beings
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
        public String getName(){
                return this.Name;
        }

}
