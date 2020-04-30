package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.AvoidBuff;

public class Consentration extends AbilityImpl  {


    private double avoidChance;

    public Consentration(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.avoidChance=0;
        this.cdTurns=7;
        this.activityTurnsNum=3;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "consentration";
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            avoidChance=0.15;
        }else{
            avoidChance+=0.15;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double multAvoidChance(){
        return avoidChance;
    }

    @Override
    public String description() {
        return null;
    }
}
