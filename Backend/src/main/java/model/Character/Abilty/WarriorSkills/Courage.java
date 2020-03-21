package model.Character.Abilty.WarriorSkills;


import model.Character.Abilty.AbilityImpl;

public class Courage extends AbilityImpl {

    private double healMult;

    public Courage(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.healMult=0;
        this.cdTurns=15;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "courage";
    }

    @Override
    public double additionalDamageTaken() {
        return 1;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            healMult=0.25;
        }else{
            healMult+=0.25;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double additionalAdilityDamage() {
        return 1;
    }

    @Override
    public double additionalHeal() {
        return healMult;
    }

    @Override
    public String description() {
        return null;
    }
}
