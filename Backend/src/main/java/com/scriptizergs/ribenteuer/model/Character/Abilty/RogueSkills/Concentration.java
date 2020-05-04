package com.scriptizergs.ribenteuer.model.Character.Abilty.RogueSkills;


import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.AVOID;

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

        description = "Over 3 rounds, " +
                "the player increases the probability of" +
                " an enemy miss by 10 \\ 30 \\ 45%. Cooldown — 7 rounds";
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

}
