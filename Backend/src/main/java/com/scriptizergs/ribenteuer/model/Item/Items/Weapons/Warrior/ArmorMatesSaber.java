package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class ArmorMatesSaber extends Item {

    public ArmorMatesSaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Armor-mate's saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 20;
        this.cost = 1250;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.15;

    }

}
