package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class PrenticesHelmet extends Item {

    public PrenticesHelmet  (String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Prentice’s helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 25;
        this.cost = 2000;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.1;

    }

}
