package model.Character.Abilty.MageSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.VampirismBuff;

public class MagicalVampirism extends AbilityImpl  {

    private double vampMult;



    public MagicalVampirism(){
        this.lvlOfAbil=0;
        this.lvl=2;
        this.vampMult=0;
        this.cdTurns=10;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "magical vampirism";
    }


    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            vampMult=0.6;
        }else{
            vampMult+=0.1;
        }

        lvlOfAbil+=1;
    }

    @Override
    public double multVampirism(){
        return vampMult;
    }

    @Override
    public String description() {
        return null;
    }
}
