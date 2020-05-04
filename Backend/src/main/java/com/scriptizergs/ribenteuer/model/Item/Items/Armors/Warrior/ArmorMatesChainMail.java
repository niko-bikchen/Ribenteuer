package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Warrior;

import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class ArmorMatesChainMail extends Item {

    public ArmorMatesChainMail(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Armor-mate's chain mail";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 25;
        this.cost = 1500;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.1;

    }

}
