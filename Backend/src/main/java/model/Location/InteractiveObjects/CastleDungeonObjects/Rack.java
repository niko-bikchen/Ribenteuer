package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class Rack extends InteractiveObjects {

    public Rack(){
        this.name = "Rack";
        this.portraitId = "2";
        this.locationType = LocationType.CASTLEDUNGEON;
    }

    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
