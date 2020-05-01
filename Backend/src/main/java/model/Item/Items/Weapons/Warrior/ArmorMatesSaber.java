package model.Item.Items.Weapons.Warrior;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class ArmorMatesSaber extends Item {

    public ArmorMatesSaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Armor-mate's saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 20;
        this.cost = 1250;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.15;

    }

}
