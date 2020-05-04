package com.scriptizergs.ribenteuer.model.Character.Abilty.WarriorSkills;


import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

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

        description = "Over 3 rounds, the player’s normal" +
                " attacks deal 15 \\ 30 \\ 45% more damage." +
                " Cooldown — 12 rounds";
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


}
