package Model.Effect;

import Model.Entities.*;
import Model.Interfaces.IEffect;

public class ChangeHealth implements IEffect
{
    private final double healthChangeValue;

    //Method for changing the heath for characters
    public ChangeHealth(double healthChangeValue)
    {
        this.healthChangeValue = healthChangeValue;
    }

    @Override
    public void apply (ACharacter character)
    {
        character.addToHealth(healthChangeValue);
    }
}

