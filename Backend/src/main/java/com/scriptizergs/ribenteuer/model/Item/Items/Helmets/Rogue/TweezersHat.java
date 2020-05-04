package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class TweezersHat extends Item {

    public TweezersHat(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Tweezer’s hat";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.05;

    }

}
