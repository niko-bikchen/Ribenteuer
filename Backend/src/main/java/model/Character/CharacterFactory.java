//developed by Vladyslav Haponenko
package model.Character;

import model.Character.Classes.Mage;
import model.Character.Classes.Rogue;
import model.Character.Classes.Warrior;

public class CharacterFactory extends BaseCharacterFactory {

    //returns a character relatively chosen type
    @Override
    public GameCharacter createCharacter(ClassesCategories type, String ownerId, String name) {
        GameCharacter character;
        switch (type)
        {
            case ROGUE:
                character=new Rogue(ownerId,name);
                break;
            case MAGE:
                character=new Mage(ownerId,name);
                break;
            case WARRIOR:
                character=new Warrior(ownerId,name);
                break;
            default: throw new IllegalArgumentException("No such character.");
        }
        return character;
    }
}
