//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Character;

public abstract class BaseCharacterFactory {

    public abstract GameCharacter createCharacter(ClassesCategories type, String ownerId, String name, int portraitId);
}
