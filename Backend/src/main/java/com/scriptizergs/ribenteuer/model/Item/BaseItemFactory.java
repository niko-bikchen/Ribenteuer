package com.scriptizergs.ribenteuer.model.Item;

import com.scriptizergs.ribenteuer.model.Character.ClassesCategories;
import com.scriptizergs.ribenteuer.model.Item.Categories.Categories;
import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;

public abstract class BaseItemFactory {

    public abstract Item createItem(ClassesCategories typeOfChar,
                                    Categories typeOfItem, LvlOfItem lvlOfStrength, String charId);

    public abstract Item createRandomItem(String charId);

}
