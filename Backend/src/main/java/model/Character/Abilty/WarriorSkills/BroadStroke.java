package model.Character.Abilty.WarriorSkills;

import model.Character.Abilty.AbilityImpl;

public class BroadStroke extends AbilityImpl {

    private double dmgMult;

    public BroadStroke(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.dmgMult=1;
        this.cdTurns=6;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "broad stroke";
    }

    @Override
    public double additionalDamageTaken() {
        return 1;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=1.5;
        }else{
            dmgMult+=0.15;
        }

        lvlOfAbil+=1;
    }


    @Override
    public double additionalAdilityDamage() {
        return dmgMult;
    }

    @Override
    public double additionalHeal() {
        return 1;
    }

    @Override
    public String description() {
        return null;
    }
}
