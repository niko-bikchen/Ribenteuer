package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public abstract class InteractiveObject {

    protected String name;

    protected String portraitId;

    protected LocationType locationType;

    protected String[] results;

    protected abstract String interact(FightCharacter fightCharacter);
}
