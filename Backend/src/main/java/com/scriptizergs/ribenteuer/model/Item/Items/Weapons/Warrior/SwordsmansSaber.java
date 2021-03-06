package com.scriptizergs.ribenteuer.model.Item.Items.Weapons.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.WEAPON;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.DAMAGE;

public class SwordsmansSaber extends Item {

    public SwordsmansSaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Swordsman’s saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 30;
        this.cost = 3250;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.35;

    }

}
