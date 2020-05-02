package model.Character.Abilty.MageSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.AbilityDamageBuff;

public class RunicExplosion extends AbilityImpl {

    private double dmgMult;

    public RunicExplosion(){
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
        return "runic explosion";
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
    public double multAbilityDamage() {
        return dmgMult;
    }


    @Override
    public String description() {
        return null;
    }
}
