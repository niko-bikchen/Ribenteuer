package model.Character.Abilty.RogueSkills;

import model.Character.Abilty.AbilityImpl;

public class Thrust extends AbilityImpl {

    private double avoidChance;

    private double dmgMult;

    public Thrust(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.dmgMult=1;
        this.avoidChance=0;
        this.cdTurns=5;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "thrust";
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=1.25;
            avoidChance=0.2;
        }else{
            dmgMult+=0.25;
            avoidChance+=0.1;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double additionalAdilityDamage() {
        return dmgMult;
    }

    @Override
    public double additionalAvoidChance(){
        return avoidChance;
    }

    @Override
    public String description() {
        return null;
    }
}
