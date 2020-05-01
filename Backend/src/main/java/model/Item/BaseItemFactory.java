package model.Item;

import model.Character.ClassesCategories;
import model.Item.Categories.Categories;

public abstract class BaseItemFactory {

    public abstract Item createItem(ClassesCategories typeOfChar,
                                    Categories typeOfItem, int lvlOfStrength, String charId);

}
