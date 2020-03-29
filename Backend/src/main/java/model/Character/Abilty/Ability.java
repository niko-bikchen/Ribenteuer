package model.Character.Abilty;


public interface Ability {

    String abilityName();

    double additionalDamageTaken();

    int skillPointsNeeded();

    void upAbility();

    int levelOfAbility();

    boolean isActive();

    void activate();

    int activityTurns();

    void deactivate();

    double additionalAdilityDamage();

    double additionalHeal();

    int cd();

    int activityTurnsLeft();

    int cdTurnsLeft();

    String description();

    void turnPassed();

    int abilityDivision();

    double additionalVampirism();

    double additionalAvoidChance();

    double additionalFinishingOff();



}
