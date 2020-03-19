//developed by Vladyslav Haponenko
package model.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//provides interaction with CharacterRepository class
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> findAllUsersChars(String id) {
        return characterRepository.findCharacterByOwnerId(id);
    }

    //should take all the parameters needed for creation of Character and
    //a String type which corresponds to exact class of character
    //
    //adds the character to repository
    //
    //parameter type expected to be rogue, mage or warrior
    @Override
    public void makeCharacter(String type,String ownerId) {
        CharacterFactory cf= new CharacterFactory();
        characterRepository.save(cf.createCharacter(type,ownerId));
    }

    @Override
    public Optional<Character> findCharacterById(String id) {
        return characterRepository.findById(id);
    }


    //the method deletes a character
    //
    //after the method is called deleteAllByOwnerId method from ItemServiceImpl must be called
    //in order to delete respective items of a character
    @Override
    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }


    //the method deletes all characters respective to the user
    //
    //for every deleted character the method deleteByOwnerId from ItemServiceImpl must be called
    @Override
    public void deleteAllByOwnerId(String id) {
        characterRepository.deleteAllByOwnerId(id);
    }
}
