package model.Item.Items.Armors.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;
import static model.Mechanics.MechanicsCategory.AVOID;

public class BanditsArmor extends Item {

    public BanditsArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Bandit’s Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 30;
        this.cost = 2500;
        this.lvlOfStrength = 2;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.15;
        this.damageTaken = 0.05;

    }

}
