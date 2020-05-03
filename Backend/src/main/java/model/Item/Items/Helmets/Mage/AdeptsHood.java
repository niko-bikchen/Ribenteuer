package model.Item.Items.Helmets.Mage;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class AdeptsHood extends Item {

    public AdeptsHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Adept’s hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 30;
        this.cost = 3000;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.15;

    }

}
