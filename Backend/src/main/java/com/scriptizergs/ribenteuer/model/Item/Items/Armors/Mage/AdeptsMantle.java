package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Mage;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

public class AdeptsMantle extends Item {

    public AdeptsMantle(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Adept’s Mantle";
        this.description = "";
        this.category = ARMORGARMENT;
        this.intelligenceNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.avoidChance = 0.1;
        this.abilityDamage = 0.2;

    }

}
