package com.scriptizergs.ribenteuer.model.Location.LocationImpl;

import com.scriptizergs.ribenteuer.model.Character.GameCharacter;

public abstract class BaseLocationFactory {
    public abstract Location generateLocation(GameCharacter gameCharacter, LocationType locType);
}
