package model.Item.Items.Armors.Rogue;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;
import static model.Mechanics.MechanicsCategory.AVOID;

public class TweezersArmor extends Item {

    public TweezersArmor(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Tweezer’s Armor";
        this.description = "";
        this.category = ARMORGARMENT;
        this.agilityNeeded = 25;
        this.cost = 1500;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ARMOR);

        this.avoidChance = 0.1;
        this.damageTaken = 0.05;

    }

}
