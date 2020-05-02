package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class LawnWithRabbit extends InteractiveObjects {

    public LawnWithRabbit(){
        this.name = "A lawn with a rabbit";
        this.portraitId = "4";
        this.locationType = LocationType.FOREST;
    }


    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
