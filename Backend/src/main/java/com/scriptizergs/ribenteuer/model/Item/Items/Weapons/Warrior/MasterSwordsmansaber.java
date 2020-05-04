package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class MasterSwordsmansaber extends Item {

    public MasterSwordsmansaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Master Swordsman saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 35;
        this.cost = 4500;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.5;

    }

}
