package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class ShadowMasterArmor extends Item {

    public ShadowMasterArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Shadow Master Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 40;
        this.cost = 5000;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.25;
        this.damageTaken = 0.1;

    }

}
