package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.Character.GameCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class OldBbookshelf extends InteractiveObjects {

    public OldBbookshelf(){
        this.name = "Old bookshelf";
        this.portraitId = "1";
        this.locationType = LocationType.CASTLEDUNGEON;
    }


    @Override
    protected GameCharacter interact(GameCharacter gameCharacter) {
        return null;
    }
}
