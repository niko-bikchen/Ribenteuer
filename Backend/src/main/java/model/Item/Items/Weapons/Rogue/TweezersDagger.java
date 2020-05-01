package model.Item.Items.Weapons.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.*;

public class TweezersDagger extends Item {

    public TweezersDagger(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Tweezer’s dagger";
        this.description = "";
        this.category = WEAPON;
        this.agilityNeeded = 20;
        this.cost = 1250;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(DAMAGE);

        this.abilityDamage = 0.05;
        this.damage = 0.1;

    }

}
