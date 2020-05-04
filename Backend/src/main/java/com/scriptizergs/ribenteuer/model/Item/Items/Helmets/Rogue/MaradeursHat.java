package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class MaradeursHat extends Item {

    public MaradeursHat(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Maradeur’s hat";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 30;
        this.cost = 3000;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.15;

    }

}
