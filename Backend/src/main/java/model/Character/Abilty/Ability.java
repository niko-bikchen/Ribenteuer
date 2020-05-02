package model.Character.Abilty;


public interface Ability {

    String abilityName();

    int skillPointsNeeded();

    void upAbility();

    int levelOfAbility();

    boolean isActive();

    void activate();

    int activityTurns();

    void deactivate();

    void setStartOptions();

    int cd();

    int activityTurnsLeft();

    int cdTurnsLeft();

    String description();

    void turnPassed();

    int abilityDivision();

    boolean activatable();





}
