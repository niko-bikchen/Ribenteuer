//developed by Vladyslav Haponenko
package model.Character.Abilty;

public abstract class AbilityImpl implements Ability {

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
    public double additionalDamageTaken(){
        return 1;
    }

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
    public double additionalAdilityDamage(){
        return 1;
    }

    @Override
    public double additionalHeal(){
        return 1;
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
    public abstract String description();


    @Override
    public double additionalVampirism(){
        return 0;
    }

    @Override
   public double additionalAvoidChance(){
        return 0;
    }

    @Override
    public double additionalFinishingOff(){
        return 0;
    }

    @Override
    public void turnPassed() {
        if(active){
            if (acTurnsLeft-1 == 0){
                deactivate();
            }else{
                acTurnsLeft-=1;
            }
        }else{
            cdDeTurnsLef=(cdDeTurnsLef == 0 ? 0 : cdDeTurnsLef-1 );
        }

    }
}
