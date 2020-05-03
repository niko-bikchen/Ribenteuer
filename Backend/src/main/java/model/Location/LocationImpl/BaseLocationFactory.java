package model.Location.LocationImpl;

import model.Character.GameCharacter;

public abstract class BaseLocationFactory {
    public abstract Location generateLocation(GameCharacter gameCharacter, LocationType locType);
}
