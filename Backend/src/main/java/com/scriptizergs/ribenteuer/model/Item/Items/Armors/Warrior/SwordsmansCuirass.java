package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class SwordsmansCuirass extends Item {

    public SwordsmansCuirass(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Swordsman’s cuirass";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.3;

    }

}
