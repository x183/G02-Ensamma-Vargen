package com.LoneWolf.Model.Interfaces;

import com.LoneWolf.Model.Entities.CharacterState;

/**
 * interface for the character class, used to get the state of the character
 */
public interface ICharacter {
        CharacterState getState();
        boolean isAlive();

}
