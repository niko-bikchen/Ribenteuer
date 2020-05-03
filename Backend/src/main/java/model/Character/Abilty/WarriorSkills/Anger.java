package model.Character.Abilty.WarriorSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class Anger extends Ability {


    public Anger(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.abilityDamage = 1.15;
        this.cdTurns=12;
        this.activityTurnsNum=3;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);
    }


    @Override
    public String abilityName() {
        return "anger";
    }

    @Override
    public void upAbility() {
        abilityDamage+=0.15;
        lvlOfAbil+=1;
    }



    @Override
    public String description() {
        return null;
    }
}
