package model.Item.Items.Helmets.Rogue;

import model.Item.Categories.LvlOfItem;
import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.HELMET;
import static model.Mechanics.MechanicsCategory.AVOID;

public class BanditsHood extends Item {

    public BanditsHood(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Bandit’s hood";
        this.description = "";
        this.category = HELMET;
        this.agilityNeeded = 25;
        this.cost = 2000;
        this.lvlOfStrength = LvlOfItem.APPRENTICE;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(AVOID);

        this.avoidChance = 0.1;

    }

}
