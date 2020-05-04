//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Character;

import com.scriptizergs.ribenteuer.model.Character.Classes.Mage;
import com.scriptizergs.ribenteuer.model.Character.Classes.Rogue;
import com.scriptizergs.ribenteuer.model.Character.Classes.Warrior;

public class CharacterFactory extends BaseCharacterFactory {

    /**
     *
     * @param type a type of character chosen by a user
     * @param ownerId an id of a user
     * @param name name of a character specified by a user
     * @return a character object that should be added into repository
     */
    @Override
    public GameCharacter createCharacter(ClassesCategories type, String ownerId, String name, int portraitId) {
        GameCharacter character;
        switch (type)
        {
            case ROGUE:
                character=new Rogue(ownerId,name,portraitId);
                break;
            case MAGE:
                character=new Mage(ownerId,name, portraitId);
                break;
            case WARRIOR:
                character=new Warrior(ownerId,name, portraitId);
                break;
            default: throw new IllegalArgumentException("No such character.");
        }
        return character;
    }
}
