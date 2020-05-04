//developed by Vladyslav Haponenko
package model.Character.Abilty;

import model.Mechanics.*;

import java.util.List;

public abstract class Ability implements AbilityDamageBuff, AvoidBuff, VampirismBuff, HealBuff, ArmorBuff, FinishingOffBuff {

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

    protected List<MechanicsCategory> types;

    protected double avoidChance = 0;

    protected double finishingOff = 0;

    protected double vampirism = 0;

    protected double abilityDamage = 1;

    protected double heal = 0;

    protected double damageTaken = 1;

    protected String description;




    public abstract String abilityName();

    public int skillPointsNeeded() {
        return lvlOfAbil-1+lvl;
    }

    public abstract void upAbility();

    public int levelOfAbility() {
        return lvlOfAbil;
    }

    public int abilityDivision(){
        return lvl;
    }

    public boolean isActive(){
        return active;
    }

    public void activate() {
        if(cdDeTurnsLef == 0){
            active=true;
            acTurnsLeft=activityTurnsNum;
        }
    }


    public int activityTurns() {
        return activityTurnsNum;
    }


    /**
     * This method is responsible for
     * deactivating an ability
     *
     * It sets an activity turns that left to 0
     * and cd turns to particular number specified
     * by ability creators
     */
    public void deactivate() {
        active=false;
        acTurnsLeft=0;
        cdDeTurnsLef=cdTurns;
    }


    public int cd() {
        return cdTurns;
    }


    public int activityTurnsLeft() {
        return acTurnsLeft;
    }


    public int cdTurnsLeft(){
        return cdDeTurnsLef;
    }


    /**
     * This method is responsible for preparing
     * an ability for fight
     *
     * Deactivates an ability and sets cd turns to 0
     */
    public void setStartOptions(){
        deactivate();
        cdDeTurnsLef = 0;
    }

    //this method checks if a skill can be activated
    public boolean activatable(){
        return !isActive() &&  (cdDeTurnsLef == 0);
    }


    /** This method is responsible for controlling
     * abilities private fields like cd, whether a skill
     * should be deactivated...
    *
     * Changes the number of activity turns that left if
     * an ability is activated
     * Changes the number of cd turns that left is
     * an ability is deactivated
     * deactivates ability if activity turns reaches 0
     */
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


    //implementations of all mechanics of skills
    @Override
    public double multAvoidChance(){
        return avoidChance;
    }

    @Override
    public double multFinishingOff(){
        return finishingOff;
    }

    @Override
    public double multVampirism(){
        return vampirism;
    }

    @Override
    public double multAbilityDamage(){
        return abilityDamage;
    }

    @Override
    public double multHeal(){
        return heal;
    }

    @Override
    public double multDamageTaken(){
        return damageTaken;
    }

}
