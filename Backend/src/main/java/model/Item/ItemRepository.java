//developed by Vladyslav Haponenko
package model.Item;

import model.Item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


//the class controls retrieving data about items

public interface ItemRepository extends MongoRepository<Item, String> {

    //retrieves all items which belong to the char with the id
    public List<Item> findByCharId(String id);

    public void deleteAllByCharId(String id);
}
