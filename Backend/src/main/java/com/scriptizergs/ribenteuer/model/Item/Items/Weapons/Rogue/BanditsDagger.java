package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Rogue;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class BanditsDagger extends Item {

    public BanditsDagger(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Bandit’s dagger";
        this.description = "";
        this.category = WEAPON;
        this.agilityNeeded = 25;
        this.cost = 2250;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.05;
        this.damage = 0.15;

    }

}
