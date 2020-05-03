package model.Item.Items.Armors.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;
import static model.Mechanics.MechanicsCategory.AVOID;

public class ShadowMasterArmor extends Item {

    public ShadowMasterArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Shadow Master Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 40;
        this.cost = 5000;
        this.lvlOfStrength = 4;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.25;
        this.damageTaken = 0.1;

    }

}
