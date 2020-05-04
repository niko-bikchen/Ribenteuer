package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class MaradeursArmor extends Item {

    public MaradeursArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Maradeur’s Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.2;
        this.damageTaken = 0.1;

    }

}
