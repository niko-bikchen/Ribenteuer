package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.FINISHING_OFF;

public class IntombmentTrick extends Ability {


    public IntombmentTrick(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.finishingOff=0.3;
        this.cdTurns=8;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(FINISHING_OFF);

        description = "The player deals 30 \\ 45 \\ 60%" +
                " of the damage already done to the enemy." +
                " Cooldown — 8 rounds";
    }

    @Override
    public String abilityName() {
        return "intombment trick";
    }

    @Override
    public void upAbility() {
        finishingOff+=0.15;
        lvlOfAbil+=1;
    }


}
