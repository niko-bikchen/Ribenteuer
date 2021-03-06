package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Mage;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class ArchimageStaff extends Item {

    public ArchimageStaff(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Archimage staff";
        this.description = "";
        this.category = WEAPON;
        this.intelligenceNeeded = 35;
        this.cost = 4500;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.25;
        this.damage = 0.1;

    }

}
