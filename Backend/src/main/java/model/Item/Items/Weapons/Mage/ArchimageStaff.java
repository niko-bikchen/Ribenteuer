package model.Item.Items.Weapons.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class ArchimageStaff extends Item {

    public ArchimageStaff(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Archimage staff";
        this.description = "";
        this.category = WEAPON;
        this.intelligenceNeeded = 35;
        this.cost = 4500;
        this.lvlOfStrength = 4;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.25;
        this.damage = 0.1;

    }

}