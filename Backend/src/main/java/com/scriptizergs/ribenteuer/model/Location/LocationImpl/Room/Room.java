//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Location.LocationImpl.Room;

import lombok.Getter;
import lombok.Setter;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import com.scriptizergs.ribenteuer.model.Location.Monsters.Monster;

import java.util.List;


//the class is supposed to be a functional unit of Location class
@Getter
@Setter
public class Room {

    private LocationType locationType;

    private RoomType roomType;

    private Monster monster;

    private List<InteractiveObject> interObjects;

    public Room(LocationType locType, RoomType roomType,
                Monster monster, List<InteractiveObject> interObjects){
        locationType = locType;
        this.roomType = roomType;
        this.monster = monster;
        this.interObjects = interObjects;
    }

}
