//developed by Vladyslav Haponenko
package model.Character.Abilty;

import model.Mechanics.*;

public abstract class AbilityImpl implements Ability, AbilityDamageBuff, AvoidBuff, VampirismBuff, HealBuff, ArmorBuff, FinishingOffBuff {

    //division of the ability
    protected int lvl;

    //level of the ability
    protected int lvlOfAbil;

    //is the ability active
    protected boolean active;

    //how much time for being active again it takes
    protected int cdTurns;

    //how much turns it will be active
    protected int activityTurnsNum;

    //how many turns the ability will be inactive
    protected int cdDeTurnsLef;

    //how many turns the ability will be active
    protected int acTurnsLeft;

    @Override
    public abstract String abilityName();


    @Override
    public int skillPointsNeeded() {
        return lvlOfAbil-1+lvl;
    }

    @Override
    public abstract void upAbility();


    @Override
    public int levelOfAbility() {
        return lvlOfAbil;
    }

    @Override
    public int abilityDivision(){
        return lvl;
    }


    @Override
    public boolean isActive(){
        return active;
    }

    @Override
    public void activate() {
        if(cdDeTurnsLef == 0){
            active=true;
            acTurnsLeft=activityTurnsNum;
        }
    }

    @Override
    public int activityTurns() {
        return activityTurnsNum;
    }

    @Override
    public void deactivate() {
        active=false;
        acTurnsLeft=0;
        cdDeTurnsLef=cdTurns;
    }


    @Override
    public int cd() {
        return cdTurns;
    }

    @Override
    public int activityTurnsLeft() {
        return acTurnsLeft;
    }

    @Override
    public int cdTurnsLeft(){
        return cdDeTurnsLef;
    }


    @Override
    public void setStartOptions(){
        deactivate();
        cdDeTurnsLef = 0;
    }

    @Override
    public boolean activatable(){
        return !isActive() &&  (cdDeTurnsLef == 0);
    }

    @Override
    public abstract String description();



    @Override
    public void turnPassed() {
        if(isActive()){
            if (acTurnsLeft-1 == 0){
                deactivate();
            }else{
                acTurnsLeft-=1;
            }
        }else{
            cdDeTurnsLef=(cdDeTurnsLef == 0 ? 0 : cdDeTurnsLef-1 );
        }

    }


    @Override
    public double multAvoidChance(){
        return 0;
    }

    @Override
    public double multFinishingOff(){
        return 0;
    }

    @Override
    public double multVampirism(){
        return 0;
    }

    @Override
    public double multAbilityDamage(){
        return 1;
    }

    @Override
    public double multHeal(){
        return 1;
    }

    @Override
    public double multDamageTaken(){
        return 1;
    }

}
