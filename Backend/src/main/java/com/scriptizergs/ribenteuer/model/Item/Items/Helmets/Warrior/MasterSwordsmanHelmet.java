package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class MasterSwordsmanHelmet extends Item {

    public MasterSwordsmanHelmet  (String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Master Swordsman helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 35;
        this.cost = 4000;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.2;

    }

}
