package model.Location.InteractiveObjects.ForestObjects;

import model.Location.InteractiveObjects.CastleDungeonObjects.CastleInteractiveObjects;
import model.Location.InteractiveObjects.InteractiveObject;

public abstract class BaseForestObjFactory {

    public abstract InteractiveObject getInteractiveObject(ForestInteractiveObjects intObj);

    public abstract InteractiveObject getRandomInteractiveObject();
}
