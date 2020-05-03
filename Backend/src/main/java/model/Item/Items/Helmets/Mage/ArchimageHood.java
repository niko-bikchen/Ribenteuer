package model.Item.Items.Helmets.Mage;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class ArchimageHood extends Item {

    public ArchimageHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Archimage hood";
        this.description = "";
        this.category = HELMET;
        this.intelligenceNeeded = 35;
        this.cost = 4000;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.abilityDamage = 0.2;

    }

}
