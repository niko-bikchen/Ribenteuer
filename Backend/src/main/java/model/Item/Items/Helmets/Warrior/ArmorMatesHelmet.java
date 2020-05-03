package model.Item.Items.Helmets.Warrior;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class ArmorMatesHelmet extends Item {

    public ArmorMatesHelmet(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Armor-mate's helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.05;

    }

}
