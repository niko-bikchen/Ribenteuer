//developed by Vladyslav Haponenko
package model.Item;


import model.Character.ClassesCategories;
import model.Item.Categories.Categories;

import java.util.List;
import java.util.Optional;

//all classes which will implement the interface will be responsible for
//interaction with CharacterRepository
public interface ItemService {

    List<Item> findAllItems();

    List<Item> findAllUsersItems(String id);

    void createItem(ClassesCategories typeOfChar, Categories typeOfItem, int lvlOfStrength, String charId);

    void deleteItem(String id);

    Optional<Item> getItemById(String id);

    void deleteAllByOwnerId(String id);

    void saveItem(Item item);

}
