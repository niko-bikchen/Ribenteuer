package model.Character.Abilty.MageSkills;


import model.Character.Abilty.AbilityImpl;

public class ArcaneBlur extends AbilityImpl {

    private double avoidMult;

    public ArcaneBlur(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.avoidMult=0;
        this.cdTurns=5;
        this.activityTurnsNum=2;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "arcane blur";
    }


    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            avoidMult=0.3;
        }else{
            avoidMult+=0.1;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double additionalAvoidChance(){
        return avoidMult;
    }

    @Override
    public String description() {
        return null;
    }
}
