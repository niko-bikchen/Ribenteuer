package model.Item.Items.Helmets.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.AVOID;

public class MaradeursHat extends Item {

    public MaradeursHat(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Maradeur’s hat";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 30;
        this.cost = 3000;
        this.lvlOfStrength = 3;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.15;

    }

}
