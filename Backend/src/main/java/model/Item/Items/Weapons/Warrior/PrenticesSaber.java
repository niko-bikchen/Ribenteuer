package model.Item.Items.Weapons.Warrior;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class PrenticesSaber extends Item {

    public PrenticesSaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Prentice’s saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 25;
        this.cost = 2250;
        this.lvlOfStrength = 2;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.25;

    }

}
