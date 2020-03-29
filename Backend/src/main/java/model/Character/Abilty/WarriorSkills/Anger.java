package model.Character.Abilty.WarriorSkills;


import model.Character.Abilty.AbilityImpl;

public class Anger extends AbilityImpl {

    private double dmgMult;

    public Anger(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.dmgMult=1;
        this.cdTurns=12;
        this.activityTurnsNum=3;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }


    @Override
    public String abilityName() {
        return "anger";
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=1.15;
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
    public String description() {
        return null;
    }
}
