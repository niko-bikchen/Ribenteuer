package model.Item.Items.Armors.Mage;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.AVOID;

public class AdeptsMantle extends Item {

    public AdeptsMantle(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Adept’s Mantle";
        this.description = "";
        this.category = ARMORGARMENT;
        this.intelligenceNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = 3;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.avoidChance = 0.1;
        this.abilityDamage = 0.2;

    }

}
