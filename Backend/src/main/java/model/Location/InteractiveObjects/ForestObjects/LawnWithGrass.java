package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class LawnWithGrass extends InteractiveObjects {

    public LawnWithGrass(){
        this.name = "Lawn with grass";
        this.portraitId = "2";
        this.locationType = LocationType.FOREST;
    }


    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
