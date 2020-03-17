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
    @Override
    public void makeCharacter(String type,String ownerId) {
        CharacterFactory cf= new CharacterFactory();
        characterRepository.save(cf.createCharacter(type,ownerId));
    }

    @Override
    public Optional<Character> findCharacterById(String id) {
        return characterRepository.findById(id);
    }

    @Override
    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }
}
