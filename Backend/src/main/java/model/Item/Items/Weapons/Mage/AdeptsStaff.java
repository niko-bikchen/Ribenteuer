package model.Item.Items.Weapons.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class AdeptsStaff extends Item {

    public AdeptsStaff(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Adept’s staff";
        this.description = "";
        this.category = WEAPON;
        this.intelligenceNeeded = 30;
        this.cost = 3250;
        this.lvlOfStrength = 3;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.2;
        this.damage = 0.1;

    }

}
