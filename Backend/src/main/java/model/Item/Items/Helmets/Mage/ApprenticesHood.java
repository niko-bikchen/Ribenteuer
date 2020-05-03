package model.Item.Items.Helmets.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class ApprenticesHood extends Item {

    public ApprenticesHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Apprentice’s hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 25;
        this.cost = 2000;
        this.lvlOfStrength = 2;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.1;

    }

}
