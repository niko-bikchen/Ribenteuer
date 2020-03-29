package model.Character.Abilty.WarriorSkills;

import model.Character.Abilty.AbilityImpl;

public class DestructiveStrike extends AbilityImpl {

    private double defenseMult;

    private double dmgMult;

    public DestructiveStrike(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.defenseMult=1;
        this.dmgMult=1;
        this.cdTurns=3;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "destructive strike";
    }

    @Override
    public double additionalDamageTaken() {
        return defenseMult;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            defenseMult=0.85;
            dmgMult=1.2;
        }else{
            defenseMult-=0.1;
            dmgMult+=0.15;
        }

        lvlOfAbil+=1;
    }


    @Override
    public double additionalAdilityDamage() {
        return dmgMult;
    }

    @Override
    public String description() {
        return null ;
    }

}
