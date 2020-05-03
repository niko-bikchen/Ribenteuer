package model.Item.Items.Helmets.Warrior;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class SwordsmansHelmet extends Item {

    public SwordsmansHelmet  (String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Swordsman’s helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 30;
        this.cost = 3000;
        this.lvlOfStrength = LvlOfItem.ADEPT;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.15;

    }

}
