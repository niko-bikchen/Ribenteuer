package model.Item.Items.Weapons.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class BeginnersStaff extends Item {

    public BeginnersStaff(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Beginner's staff";
        this.description = "";
        this.category = WEAPON;
        this.intelligenceNeeded = 20;
        this.cost = 1250;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.1;
        this.damage = 0.05;

    }

}
