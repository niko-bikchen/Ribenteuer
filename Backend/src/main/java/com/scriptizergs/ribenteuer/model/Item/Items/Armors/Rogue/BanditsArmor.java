package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class BanditsArmor extends Item {

    public BanditsArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Bandit’s Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 30;
        this.cost = 2500;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.15;
        this.damageTaken = 0.05;

    }

}
