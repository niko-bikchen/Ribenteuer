package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class ThePlaceOfRitual extends InteractiveObjects {

    public ThePlaceOfRitual(){
        this.name = "The place of ritual";
        this.portraitId = "5";
        this.locationType = LocationType.CASTLEDUNGEON;
    }

    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
