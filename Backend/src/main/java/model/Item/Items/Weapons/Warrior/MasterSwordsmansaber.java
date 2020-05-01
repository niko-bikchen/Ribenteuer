package model.Item.Items.Weapons.Warrior;

import model.Item.Item;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Item.Categories.Categories.WEAPON;
import static model.Mechanics.MechanicsCategory.DAMAGE;

public class MasterSwordsmansaber extends Item {

    public MasterSwordsmansaber(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Master Swordsman saber";
        this.description = "";
        this.category = WEAPON;
        this.strengthNeeded = 35;
        this.cost = 4500;
        this.lvlOfStrength = 4;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        this.mechanicsCategoryList.add(DAMAGE);

        this.damage = 0.5;

    }

}
