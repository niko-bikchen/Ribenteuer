package model.Item.Items.Armors.Warrior;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.ARMORGARMENT;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class PrenticesCuirass extends Item {

    public PrenticesCuirass(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Prentice’s cuirass";
        this.description = "";
        this.category = ARMORGARMENT;
        this.strengthNeeded = 30;
        this.cost = 2500;
        this.lvlOfStrength = 2;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.2;

    }

}
