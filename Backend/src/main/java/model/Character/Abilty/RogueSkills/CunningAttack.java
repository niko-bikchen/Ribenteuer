package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class CunningAttack extends Ability {

    public CunningAttack(){
        this.lvlOfAbil=1;
        this.lvl=1;
        this.abilityDamage = 0.6;
        this.damageTaken = 0.85;
        this.cdTurns=6;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);
    }

    @Override
    public String abilityName() {
        return "cunning attack";
    }


    @Override
    public void upAbility() {
        abilityDamage+=0.1;
        damageTaken-=0.1;
        lvlOfAbil+=1;
    }



    @Override
    public String description() {
        return null;
    }
}
