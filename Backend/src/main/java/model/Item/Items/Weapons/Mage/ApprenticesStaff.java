package model.Item.Items.Weapons.Mage;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class ApprenticesStaff extends Item {

    public ApprenticesStaff(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Apprentice’s staff";
        this.description = "";
        this.category = WEAPON;
        this.intelligenceNeeded = 25;
        this.cost = 2250;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.15;
        this.damage = 0.05;

    }

}
