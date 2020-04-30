//developed by Vladyslav Haponenko
package model.Character;

public abstract class BaseCharacterFactory {

    public abstract GameCharacter createCharacter(String type, String ownerId, String name);
}
