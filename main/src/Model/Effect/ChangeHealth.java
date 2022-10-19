package Model.Effect;

import Model.Entities.*;
import Model.Interfaces.IEffect;

/**
 * The ChangeHealth class is the class that represents the effect of changing the health of a character.
 * It implements the interface IEffect
 * currently not really used since effects are not really used
 */
public class ChangeHealth implements IEffect
{
    private final double healthChangeValue;

    /**
     * The constructor for the ChangeHealth class
     */
    //Method for changing the heath for characters
    public ChangeHealth(double healthChangeValue)
    {
        this.healthChangeValue = healthChangeValue;
    }
    /**
     * applyEffect() applies the effect of changing the health of a character
     * @param character the character to apply the effect to
     */
    @Override
    public void apply (ACharacter character)
    {
        character.addHealth(healthChangeValue);
    }
}

