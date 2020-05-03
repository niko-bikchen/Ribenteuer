package model.Item.Items.Armors.Mage;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.AVOID;

public class ArchimageMantle extends Item {

    public ArchimageMantle(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Archimage Mantle";
        this.description = "";
        this.category = ARMORGARMENT;
        this.intelligenceNeeded = 40;
        this.cost = 5000;
        this.lvlOfStrength = LvlOfItem.MASTER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.avoidChance = 0.1;
        this.abilityDamage = 0.25;

    }

}
