//developed by Vladyslav Haponenko
package model.Character;

import model.Item.Item;

import java.util.List;
import java.util.Optional;

//all classes which implement the interface will be responsible for
//interaction with CharacterRepository
public interface CharacterService {
    List<GameCharacter> findAll();

    List<GameCharacter> findAllUsersChars(String id);

    //make the Character based on value for it's fields and type
    void makeCharacter(ClassesCategories type, String ownerId, String name);

    Optional<GameCharacter> findCharacterById(String id);

    void deleteCharacter(String id);

    void deleteAllByOwnerId(String id);

    List<Item> takeAllItemsById(String id);

    void updateChar(GameCharacter gChar);

    List<Item> takeAllEquipedItemsById(String id);
}
