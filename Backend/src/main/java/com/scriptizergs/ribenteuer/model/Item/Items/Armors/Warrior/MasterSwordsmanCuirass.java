package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class MasterSwordsmanCuirass extends Item {

    public MasterSwordsmanCuirass(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Master Swordsman cuirass";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 40;
        this.cost = 5000;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.4;

    }

}
