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
        CharacterState state;

        public ACharacter(double Strength, double Health, String Name, double Armor)
        {
                this.Strength = Strength;
                this.maxHealth = Health;
                this.currentHealth = Health;
                this.Name = Name;
                this.Armor = Armor;
                this.state = CharacterState.ALIVE;


        }
        public void addHealth(double value)
        {
                if(value>0) {
                        currentHealth += Math.min(value, maxHealth);
                }
        }
        public void removeHealth(double value){
                if(value>0) {
                        currentHealth -= value;
                }
                if(currentHealth<=0){
                        this.state = CharacterState.DEAD;
                }
        }

        //Boolean for if a character is alive or not

        public CharacterState getState(){
                return state;
        }
        public boolean isAlive(){
                return state==CharacterState.ALIVE;
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
