package Model.Interfaces;

import Model.Entities.CharacterState;

public interface ICharacter {
        CharacterState getState();
        boolean isAlive();

}
