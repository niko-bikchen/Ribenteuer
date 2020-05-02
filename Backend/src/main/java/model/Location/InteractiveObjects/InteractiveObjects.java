package model.Location.InteractiveObjects;

import model.Character.GameCharacter;
import model.Location.LocationImpl.LocationType;

public abstract class InteractiveObjects {

    protected String name;

    protected String portraitId;

    protected LocationType locationType;

    protected abstract GameCharacter interact(GameCharacter gameCharacter);
}
