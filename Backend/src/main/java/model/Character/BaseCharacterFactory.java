//developed by Vladyslav Haponenko
package model.Character;

public abstract class BaseCharacterFactory {

    public abstract Character createCharacter(String type,String ownerId);
}
