package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.AbilityImpl;

import java.util.Random;

public class HailOfBlows extends AbilityImpl {

    private double chanceToHit;

    private double dmgMult;

    public HailOfBlows(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.dmgMult=1;
        this.chanceToHit=0;
        this.cdTurns=8;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "hail of blows";
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=0.7;
            chanceToHit=0.8;
        }else{
            dmgMult+=0.1;
            chanceToHit+=0.05;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double additionalAdilityDamage() {
        Random r = new Random();
        double dmgM=0;
        for( int i=0 ;i<3;i++){
            dmgM+=(r.nextDouble() <= chanceToHit ? dmgMult : 0);
        }
        return dmgM;
    }


    @Override
    public String description() {
        return null;
    }
}
