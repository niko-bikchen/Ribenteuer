package model.Character.Abilty.WarriorSkills;


import model.Character.Abilty.AbilityImpl;
import model.Mechanics.ArmorBuff;

public class DefensiveStand extends AbilityImpl {

    private double defenseMult;

    public DefensiveStand(){
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
        return "defensive stand";
    }

    @Override
    public double multDamageTaken() {
       return defenseMult;
    }

    @Override
    public void upAbility() {
        if(lvlOfAbil==0){
            defenseMult=0.8;
        }else{
            defenseMult-=0.2;
        }

        lvlOfAbil+=1;
    }

    @Override
    public String description() {
        return null;
    }

}
