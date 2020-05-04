package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects;

import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;

public abstract class BaseCastleIntObjFactory {

    public abstract InteractiveObject getInteractiveObject(CastleInteractiveObjects intObj);

    public abstract InteractiveObject getRandomInteractiveObject();

}
