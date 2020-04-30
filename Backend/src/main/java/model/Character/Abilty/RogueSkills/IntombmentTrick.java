package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.AbilityDamageBuff;
import model.Mechanics.FinishingOffBuff;

public class IntombmentTrick extends AbilityImpl  {

    private double finishingMult;

    public IntombmentTrick(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.finishingMult=0;
        this.cdTurns=8;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "intombment trick";
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            finishingMult=0.3;
        }else{
            finishingMult+=0.15;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double multFinishingOff(){
        return finishingMult;
    }

    @Override
    public String description() {
        return null;
    }
}
