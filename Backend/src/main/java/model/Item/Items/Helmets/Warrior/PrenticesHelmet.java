package model.Item.Items.Helmets.Warrior;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class PrenticesHelmet extends Item {

    public PrenticesHelmet  (String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Prentice’s helmet";
        this.description = "";
        this.category = HELMET;
        this.strengthNeeded = 25;
        this.cost = 2000;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(ARMOR);

        this.damageTaken = 0.1;

    }

}
