package model.Item.Items.Armors.Mage;

import lombok.Getter;
import lombok.Setter;
import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.AVOID;

@Getter
@Setter
public class BeginnersMantle extends Item {

    public BeginnersMantle(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Beginner's mantle";
        this.description = "";
        this.category = ARMORGARMENT;
        this.intelligenceNeeded = 25;
        this.cost = 1500;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.avoidChance = 0.05;
        this.abilityDamage = 0.1;

    }




}
