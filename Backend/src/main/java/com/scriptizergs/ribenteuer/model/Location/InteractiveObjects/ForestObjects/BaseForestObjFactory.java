package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects;

import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;

public abstract class BaseForestObjFactory {

    public abstract InteractiveObject getInteractiveObject(ForestInteractiveObjects intObj);

    public abstract InteractiveObject getRandomInteractiveObject();
}
