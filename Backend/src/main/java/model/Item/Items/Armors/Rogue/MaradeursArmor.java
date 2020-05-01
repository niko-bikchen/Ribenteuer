package model.Item.Items.Armors.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;
import static model.Mechanics.MechanicsCategory.AVOID;

public class MaradeursArmor extends Item {

    public MaradeursArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Maradeur’s Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = 3;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.2;
        this.damageTaken = 0.1;

    }

}
