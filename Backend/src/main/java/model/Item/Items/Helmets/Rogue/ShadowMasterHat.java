package model.Item.Items.Helmets.Rogue;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.AVOID;

public class ShadowMasterHat extends Item {

    public ShadowMasterHat(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Shadow Master hat";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 35;
        this.cost = 4000;
        this.lvlOfStrength = 4;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.2;

    }

}
