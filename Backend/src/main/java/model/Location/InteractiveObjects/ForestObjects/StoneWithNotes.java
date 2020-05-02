package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class StoneWithNotes extends InteractiveObjects {

    public StoneWithNotes(){
        this.name = "Stone with notes";
        this.portraitId = "1";
        this.locationType = LocationType.FOREST;
    }

    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }

}
