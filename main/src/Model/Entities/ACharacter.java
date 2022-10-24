package Model.Entities;

import Model.Interfaces.ICharacter;

//Parent class to all the alive beings in the game
//All alive beings have a name, strength, armor and health value, both max and current
/**
 * The ACharacter class is the abstract class that represents the characters in the game. It implements the interface ICharacter
 */
public abstract class ACharacter implements ICharacter {
        /**
         * Variables that all ACharacters must have
         */
        String Name;
        double Strength;
        double maxHealth;
        double currentHealth;
        double Armor;
        CharacterState state;

        /**
         * The constructor for the ACharacter class
         */
        public ACharacter(double Strength, double Health, String Name, double Armor)
        {
                this.Strength = Strength;
                this.maxHealth = Health;
                this.currentHealth = Health;
                this.Name = Name;
                this.Armor = Armor;
                this.state = CharacterState.ALIVE;
        }

        /**
         * addHealth() adds health to the characters health
         * @param value the amount to increase by
         */
        public void addHealth(double value)
        {
                if(value>0) {
                        currentHealth += Math.min(value, maxHealth);
                }
        }
        /**
         * removeHealth() removes health from the characters health
         * @param value the amount to decrease by
         */
        public void removeHealth(double value){
                if(value>0) {
                        currentHealth -= value;
                }
                if(currentHealth<=0){
                        currentHealth = 0;
                        this.state = CharacterState.DEAD;
                }
        }

        /**
         * getState() returns the state of the character
         * @return state
         */
        public CharacterState getState(){
                return state;
        }

        /**
         * isAlive() returns true if the character is alive
         * @return true if the character is alive
         */
        public boolean isAlive(){
                return state==CharacterState.ALIVE;
        }

        /**
         * getStrength() returns the strength of the character
         * @return strength
         */
        public double getStrength()
        {
                return this.Strength;
        }
        /**
         * getHealth() returns the max health of the character
         * @return health
         */
        public double getmaxHealth()
        {
                return this.maxHealth;
        }
        /**
         * getHealth() returns the current health of the character
         * @return health
         */
        public double getCurrentHealth()
        {
                return this.currentHealth;
        }

        /**
         * getName() returns the name of the character
         * @return name
         */
        public String getName()
        {
                return this.Name;
        }
        /**
         * getArmor() returns the armor of the character
         * @return armor
         */
        public double getArmor()
        {
                return this.Armor;
        }

        public void performAction() {
        }
}
