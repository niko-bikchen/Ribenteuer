package com.scriptizergs.ribenteuer.model.Character.Abilty.MageSkills;


import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;
import java.util.Random;

import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class FieryBlizzard extends Ability {


    private double chanceToHit;

    public FieryBlizzard(){
        this.lvlOfAbil=1;
        this.lvl=1;
        this.abilityDamage = 0.6;
        this.chanceToHit = 0.7;
        this.cdTurns=5;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);

        description = "The player deals 2 hits with" +
                " a power of 60\\75\\90% from his" +
                " ability damage with a probability" +
                " of getting 70 \\ 80 \\ 90% each. Cooldown — 5 rounds";
    }

    @Override
    public String abilityName() {
        return "fiery blizzard";
    }


    @Override
    public void upAbility() {
        abilityDamage+=0.15;
        chanceToHit+=0.1;
        lvlOfAbil+=1;
    }

    @Override
    public double multAbilityDamage() {
        Random r = new Random();
        double h_first=r.nextDouble();
        double h_second=r.nextDouble();
        return (h_first <=chanceToHit ? abilityDamage : 0) +
                (h_second <=chanceToHit ? abilityDamage : 0);
    }

}
