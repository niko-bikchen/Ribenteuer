package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class StoneBlockage extends InteractiveObjects {

    public StoneBlockage(){
        this.name = "Stone blockage";
        this.portraitId = "3";
        this.locationType = LocationType.CASTLEDUNGEON;
    }

    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
