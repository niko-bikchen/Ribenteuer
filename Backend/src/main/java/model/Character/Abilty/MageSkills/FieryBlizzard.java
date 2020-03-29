package model.Character.Abilty.MageSkills;


import model.Character.Abilty.AbilityImpl;

import java.util.Random;

public class FieryBlizzard extends AbilityImpl {

    private double dmgMult;
    private double chanceToHit;

    public FieryBlizzard(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.dmgMult=1;
        this.chanceToHit=0;
        this.cdTurns=5;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "fiery blizzard";
    }


    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=0.6;
            chanceToHit=0.7;
        }else{
            dmgMult+=0.15;
            chanceToHit+=0.1;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double additionalAdilityDamage() {
        Random r = new Random();
        double h_first=r.nextDouble();
        double h_second=r.nextDouble();
        return (h_first <=chanceToHit ? dmgMult : 0) +
                (h_second <=chanceToHit ? dmgMult : 0);
    }

    @Override
    public String description() {
        return null;
    }
}
