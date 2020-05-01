package model.Character.Abilty.WarriorSkills;

import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.ARMOR;

public class DestructiveStrike extends Ability {

    public DestructiveStrike(){
        this.lvlOfAbil=1;
        this.lvl=1;
        this.damageTaken=0.85;
        this.abilityDamage=1.2;
        this.cdTurns=3;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);
        types.add(ARMOR);
    }

    @Override
    public String abilityName() {
        return "destructive strike";
    }

    @Override
    public void upAbility() {
        damageTaken-=0.1;
        abilityDamage+=0.15;
        lvlOfAbil+=1;
    }


    @Override
    public String description() {
        return null ;
    }

}
