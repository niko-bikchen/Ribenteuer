package model.Item.Items.Weapons.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.AVOID;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class MaradeursDagger extends Item {

    public MaradeursDagger(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Maradeur’s dagger";
        this.description = "";
        this.category = WEAPON;
        this.agilityNeeded = 30;
        this.cost = 3250;
        this.lvlOfStrength = 3;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.1;
        this.damage = 0.2;

    }

}
