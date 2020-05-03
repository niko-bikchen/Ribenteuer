package model.Item.Items.Armors.Warrior;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class SwordsmansCuirass extends Item {

    public SwordsmansCuirass(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Swordsman’s cuirass";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 35;
        this.cost = 3500;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.3;

    }

}
