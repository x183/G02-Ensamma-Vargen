package Model.Interfaces;

import Model.Entities.ACharacter;

/**
 * Interface for the Effect classes, used to apply effects to the player
 */
public interface IEffect
{
    void apply(ACharacter character);
}
