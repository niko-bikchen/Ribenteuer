//developed by Vladyslav Haponenko
package model.Item;


import java.util.List;

//all classes which will implement the interface will be responsible for
//interaction with CharacterRepository
public interface ItemService {

    List<Item> findAllItems();

    List<Item> findAllUsersItems(String id);

    //TODO
    void createItem();

    void deleteItem(String id);

    void buyItem(String itemId,String newOwnerId);

    Item getItemById(String id);

}
