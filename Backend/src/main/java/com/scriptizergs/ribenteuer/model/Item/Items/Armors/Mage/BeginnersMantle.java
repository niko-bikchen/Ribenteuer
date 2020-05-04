package com.scriptizergs.ribenteuer.model.Item.Items.Armors.Mage;

import lombok.Getter;
import lombok.Setter;
import com.scriptizergs.ribenteuer.model.Item.Categories.LvlOfItem;
import com.scriptizergs.ribenteuer.model.Item.Item;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Item.Categories.Categories.ARMORGARMENT;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

@Getter
@Setter
public class BeginnersMantle extends Item {

    public BeginnersMantle(String charId ){
        this.equipped = false;
        this.charId = charId;
        this.name = "Beginner's mantle";
        this.description = "";
        this.category = ARMORGARMENT;
        this.intelligenceNeeded = 25;
        this.cost = 1500;
        this.lvlOfStrength = LvlOfItem.BEGGINER;

        this.mechanicsCategoryList = new LinkedList<MechanicsCategory>();
        mechanicsCategoryList.add(AVOID);
        this.mechanicsCategoryList.add(ABILITY_DAMAGE);

        this.avoidChance = 0.05;
        this.abilityDamage = 0.1;

    }




}
