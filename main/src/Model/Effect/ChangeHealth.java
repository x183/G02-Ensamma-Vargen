package Model.Effect;

import Model.Entities.*;

public class ChangeHealth implements IEffect
{
    private final double healthChangeValue;

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

