package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Mage;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class ApprenticesHood extends Item {

    public ApprenticesHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Apprentice’s hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 25;
        this.cost = 2000;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.1;

    }

}
