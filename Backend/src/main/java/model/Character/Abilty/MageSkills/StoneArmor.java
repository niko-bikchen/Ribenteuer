package model.Character.Abilty.MageSkills;

import model.Character.Abilty.AbilityImpl;

public class StoneArmor extends AbilityImpl {

    private double defenseMult;

    public StoneArmor(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.defenseMult=1;
        this.cdTurns=7;
        this.activityTurnsNum=3;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "stone armor";
    }

    @Override
    public double additionalDamageTaken() {
        return defenseMult;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            defenseMult=0.7;
        }else{
            defenseMult-=0.15;
        }

        lvlOfAbil+=1;
    }

    @Override
    public String description() {
        return null;
    }
}
