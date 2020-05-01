package model.Character.Abilty.WarriorSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.HEAL;

public class Courage extends Ability {

    public Courage(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.heal=0.25;
        this.cdTurns=15;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(HEAL);
    }

    @Override
    public String abilityName() {
        return "courage";
    }


    @Override
    public void upAbility() {
        heal+=0.25;
        lvlOfAbil+=1;
    }


    @Override
    public String description() {
        return null;
    }

}
