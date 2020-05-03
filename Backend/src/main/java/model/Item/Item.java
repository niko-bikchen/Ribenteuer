//developed by Vladyslav Haponenko
package model.Item;

import lombok.Getter;
import lombok.Setter;
import model.Item.Categories.Categories;
import model.Item.Categories.LvlOfItem;
import model.Mechanics.*;
import org.springframework.data.annotation.Id;

import java.util.List;


//the class describes items and relates to the owner
@Getter
@Setter
public abstract class Item implements AbilityDamageBuff ,DamageBuff, AvoidBuff, VampirismBuff, HealBuff, ArmorBuff, FinishingOffBuff{

    @Id
    protected String id;

    protected String charId;

    protected boolean equipped;

    protected String name;

    protected String description;

    protected Categories category;

    protected List<MechanicsCategory> mechanicsCategoryList;

    protected int cost = 0;

    protected int agilityNeeded = 0;

    protected int intelligenceNeeded = 0;

    protected int strengthNeeded = 0;

    protected double avoidChance = 0;

    protected double finishingOff = 0;

    protected double vampirism = 0;

    protected double abilityDamage = 1;

    protected double heal = 0;

    protected double damageTaken = 1;

    protected double damage = 1;

    protected LvlOfItem lvlOfStrength;

    public boolean isEquipped(){
        return equipped;
    }

    //implementations of all mechanics of skills
    @Override
    public double multAvoidChance(){
        return avoidChance;
    }

    @Override
    public double multFinishingOff(){
        return finishingOff;
    }

    @Override
    public double multVampirism(){
        return vampirism;
    }

    @Override
    public double multAbilityDamage(){
        return abilityDamage;
    }

    @Override
    public double multHeal(){
        return heal;
    }

    @Override
    public double multDamageTaken(){
        return damageTaken;
    }

    @Override
    public double multDamage(){
        return damage;
    }
}
