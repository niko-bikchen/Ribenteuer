package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;
import java.util.Random;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class HailOfBlows extends Ability {

    private double chanceToHit;


    public HailOfBlows(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.abilityDamage = 0.7;
        this.chanceToHit=0.8;
        this.cdTurns=8;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);

        description = "The player deals 3 hits with a power of 70" +
                " \\ 80 \\ 90% from his ability damage" +
                " with a probability of getting 80" +
                " \\ 85 \\ 90% each. Cooldown — 8 rounds";
    }

    @Override
    public String abilityName() {
        return "hail of blows";
    }

    @Override
    public void upAbility() {
        abilityDamage+=0.1;
        chanceToHit+=0.05;
        lvlOfAbil+=1;
    }

    @Override
    public double multAbilityDamage() {
        Random r = new Random();
        double dmgM=0;
        for( int i=0 ;i<3;i++){
            dmgM+=(r.nextDouble() <= chanceToHit ? abilityDamage : 0);
        }
        return dmgM;
    }


}
