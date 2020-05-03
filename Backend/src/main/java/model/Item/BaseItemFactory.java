package model.Item;

import model.Character.ClassesCategories;
import model.Item.Categories.Categories;
import model.Item.Categories.LvlOfItem;

public abstract class BaseItemFactory {

    public abstract Item createItem(ClassesCategories typeOfChar,
                                    Categories typeOfItem, LvlOfItem lvlOfStrength, String charId);

    public abstract Item createRandomItem(String charId);

}
