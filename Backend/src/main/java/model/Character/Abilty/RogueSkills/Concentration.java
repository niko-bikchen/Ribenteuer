package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.AVOID;

public class Concentration extends Ability {


    public Concentration(){
        this.lvlOfAbil=1;
        this.lvl=1;
        this.avoidChance = 0.15;
        this.cdTurns=7;
        this.activityTurnsNum=3;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(AVOID);
    }

    @Override
    public String abilityName() {
        return "concentration";
    }

    @Override
    public void upAbility() {
        avoidChance+=0.15;
        lvlOfAbil+=1;
    }


    @Override
    public String description() {
        return null;
    }
}
