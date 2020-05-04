package com.scriptizergs.ribenteuer.model.Item;

import com.scriptizergs.ribenteuer.model.Character.ClassesCategories;
import com.scriptizergs.ribenteuer.model.Item.Categories.Categories;
import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    ItemFactoryImpl itemFactory;

    public ItemServiceImpl() {
        itemFactory = new ItemFactoryImpl();
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllUsersItems(String id) {
        return itemRepository.findByCharId(id);
    }

    @Override
    public void createItem(ClassesCategories typeOfChar, Categories typeOfItem,
                           LvlOfItem lvlOfStrength, String charId) {
        itemRepository.save(itemFactory.createItem(typeOfChar, typeOfItem, lvlOfStrength, charId));
    }

    @Override
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public void deleteAllByCharId(String id) {
        itemRepository.deleteAllByCharId(id);
    }

    @Override
    public void saveItem(Item item){
        itemRepository.save(item);
    }
}
