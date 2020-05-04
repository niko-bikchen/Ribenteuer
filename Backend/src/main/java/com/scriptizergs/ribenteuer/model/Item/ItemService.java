//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Item;


import com.scriptizergs.ribenteuer.model.Character.ClassesCategories;
import com.scriptizergs.ribenteuer.model.Item.Categories.Categories;
import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;

import java.util.List;
import java.util.Optional;

//all classes which will implement the interface will be responsible for
//interaction with CharacterRepository
public interface ItemService {

    List<Item> findAllItems();

    List<Item> findAllUsersItems(String id);

    void createItem(ClassesCategories typeOfChar, Categories typeOfItem, LvlOfItem lvlOfStrength, String charId);

    void deleteItem(String id);

    Optional<Item> getItemById(String id);

    void deleteAllByCharId(String id);

    void saveItem(Item item);

}
