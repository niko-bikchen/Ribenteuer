package com.scriptizergs.ribenteuer.model.Character.Abilty.WarriorSkills;


import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.HEAL;

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

        description = "The player recovers 25 \\ 50 \\ 75%" +
                " of his lost health. Cooldown — 15 rounds";
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


}
