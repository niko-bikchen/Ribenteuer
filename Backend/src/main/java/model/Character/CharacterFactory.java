//developed by Vladyslav Haponenko
package model.Character;

public class CharacterFactory extends BaseCharacterFactory {

    //returns a character relatively chosen type
    @Override
    public Character createCharacter(String type,String ownerId) {
        Character character;
        switch (type.toLowerCase())
        {
            case "rogue":
                character=new Rogue(ownerId,17,18,25);
                break;
            case "mage":
                character=new Mage(ownerId,14,28,18);
                break;
            case "warrior":
                character=new Warrior(ownerId,26,14,20);
                break;
            default: throw new IllegalArgumentException("No such character.");
        }
        return character;
    }
}
