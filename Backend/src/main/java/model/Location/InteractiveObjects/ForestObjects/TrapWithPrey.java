package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class TrapWithPrey extends InteractiveObjects {

    public TrapWithPrey(){
        this.name = "Trap with prey";
        this.portraitId = "5";
        this.locationType = LocationType.FOREST;
    }


    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
