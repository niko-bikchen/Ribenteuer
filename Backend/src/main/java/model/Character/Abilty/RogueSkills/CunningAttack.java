package model.Character.Abilty.RogueSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.AbilityDamageBuff;
import model.Mechanics.ArmorBuff;

public class CunningAttack extends AbilityImpl  {

    private double defenseMult;

    private double dmgMult;

    public CunningAttack(){
        this.lvlOfAbil=0;
        this.lvl=1;
        this.dmgMult=1;
        this.defenseMult=1;
        this.cdTurns=6;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;
    }

    @Override
    public String abilityName() {
        return "cunning attack";
    }

    @Override
    public double multDamageTaken() {
        return defenseMult;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            dmgMult=0.6;
            defenseMult=0.85;
        }else{
            dmgMult+=0.1;
            defenseMult-=0.1;
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
