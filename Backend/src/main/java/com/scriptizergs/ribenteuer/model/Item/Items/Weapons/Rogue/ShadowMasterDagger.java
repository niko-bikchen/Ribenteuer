package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class ShadowMasterDagger extends Item {

    public ShadowMasterDagger(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Shadow Master dagger";
        this.description = "";
        this.category = WEAPON;
        this.agilityNeeded = 35;
        this.cost = 4500;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.1;
        this.damage = 0.25;

    }

}
