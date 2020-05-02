package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class BushWithBerries extends InteractiveObjects {

    public BushWithBerries(){
        this.name = "A bush with berries";
        this.portraitId = "3";
        this.locationType = LocationType.FOREST;
    }


    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
