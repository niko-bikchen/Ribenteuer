package model.Item.Items.Helmets.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.AVOID;

public class TweezersHat extends Item {

    public TweezersHat(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Tweezer’s hat";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 20;
        this.cost = 1000;
        this.lvlOfStrength = 1;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.05;

    }

}
