package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class TheHandleInThePileOfStones extends InteractiveObjects {

    public TheHandleInThePileOfStones(){
        this.name = "The handle in the pile of stones";
        this.portraitId = "4";
        this.locationType = LocationType.CASTLEDUNGEON;
    }

    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
