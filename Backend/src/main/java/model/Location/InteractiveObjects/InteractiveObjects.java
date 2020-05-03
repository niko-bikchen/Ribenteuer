package model.Location.InteractiveObjects;

import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Location.LocationImpl.LocationType;

public abstract class InteractiveObjects {

    protected String name;

    protected String portraitId;

    protected LocationType locationType;

    protected String[] results;

    protected abstract String interact(FightCharacter fightCharacter);
}
