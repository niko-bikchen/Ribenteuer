//developed by Vladyslav Haponenko
package model.Character;

import java.util.List;

//all classes which implement the interface will be responsible for
//interaction with CharacterRepository
public interface CharacterService {
    List<Character> findAll();

    List<Character> findAllUsersChars(String id);

    //TODO
    void makeCharacter();

    Character findCharacterById(String id);

    void deleteCharacter(String id);
}
