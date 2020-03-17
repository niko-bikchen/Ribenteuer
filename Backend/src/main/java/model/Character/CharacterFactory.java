package model.Character;

public class CharacterFactory extends BaseCharacterFactory {

    @Override
    public Character createCharacter(String type,String ownerId) {
        Character character;
        switch (type.toLowerCase())
        {
            case "rogue":
                character=new Rogue();
                character.setOwnerId(ownerId);
                break;
            case "mage":
                character=new Mage();
                character.setOwnerId(ownerId);
                break;
            case "warrior":
                character=new Warrior();
                character.setOwnerId(ownerId);
                break;
            default: throw new IllegalArgumentException("No such character.");
        }
        return character;
    }
}
