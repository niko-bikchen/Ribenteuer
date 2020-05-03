package model.Item.Items.Helmets.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class BeginnersHood extends Item {

    public BeginnersHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Beginner's hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.05;

    }

}
