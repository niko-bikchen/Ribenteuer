package com.scriptizergs.ribenteuer.model.Item.Items.Helmets.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.HELMET;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class ArmorMatesHelmet extends Item {

    public ArmorMatesHelmet(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Armor-mate's helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.05;

    }

}
