package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Mage;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class BeginnersHood extends Item {

    public BeginnersHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Beginner's hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.05;

    }

}
