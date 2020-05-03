package model.Item.Items.Weapons.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.AVOID;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class BanditsDagger extends Item {

    public BanditsDagger(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Bandit’s dagger";
        this.description = "";
        this.category = WEAPON;
        this.agilityNeeded = 25;
        this.cost = 2250;
        this.lvlOfStrength = 2;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.05;
        this.damage = 0.15;

    }

}
