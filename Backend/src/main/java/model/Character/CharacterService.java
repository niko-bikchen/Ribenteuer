//developed by Vladyslav Haponenko
package model.Character;

import java.util.List;
import java.util.Optional;

//all classes which implement the interface will be responsible for
//interaction with CharacterRepository
public interface CharacterService {
    List<Character> findAll();

    List<Character> findAllUsersChars(String id);

    //make the Character based on value for it's fields and type
    void makeCharacter(String type,String ownerId);

    Optional<Character> findCharacterById(String id);

    void deleteCharacter(String id);

    void deleteAllByOwnerId(String id);
}
