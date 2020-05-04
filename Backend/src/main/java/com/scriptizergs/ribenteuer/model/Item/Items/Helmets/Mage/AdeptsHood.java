package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Mage;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class AdeptsHood extends Item {

    public AdeptsHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Adept’s hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 30;
        this.cost = 3000;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.15;

    }

}
