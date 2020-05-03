//developed by Vladyslav Haponenko
package model.Character;

import model.Item.Item;
import model.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//provides interaction with CharacterRepository class
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<GameCharacter> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public List<GameCharacter> findAllUsersChars(String id) {
        return characterRepository.findGameCharacterByOwnerId(id);
    }


    //should take all the parameters needed for creation of Character and
    //a String type which corresponds to exact class of character
    //
    //adds the character to repository
    //
    //parameter type expected to be ROGUE, MAGE or WARRIOR
    @Override
    public void makeCharacter(ClassesCategories type, String ownerId, String name) {
        CharacterFactory cf = new CharacterFactory();

        GameCharacter gChar = characterRepository.findByNameAndOwnerId(name, ownerId);

        if( gChar == null){
            characterRepository.save(cf.createCharacter(type, ownerId, name));
        }
    }

    @Override
    public Optional<GameCharacter> findCharacterById(String id) {
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

    @Override
    public List<Item> takeAllItemsById(String id) {
        return itemRepository.findByCharId(id);
    }

    @Override
    public void updateChar(GameCharacter gChar){
        characterRepository.save(gChar);
    }


    @Override
    public List<Item> takeAllEquipedItemsById(String id){
        List<Item> items = takeAllItemsById(id);
        return items.stream().filter(item -> item.isEquipped()).collect(Collectors.toList());
    }
}
