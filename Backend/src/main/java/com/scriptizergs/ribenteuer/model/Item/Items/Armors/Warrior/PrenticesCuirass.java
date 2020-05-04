package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class PrenticesCuirass extends Item {

    public PrenticesCuirass(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Prentice’s cuirass";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 30;
        this.cost = 2500;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.2;

    }

}
