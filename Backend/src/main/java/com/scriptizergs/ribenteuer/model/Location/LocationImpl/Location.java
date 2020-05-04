//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Location.LocationImpl;


import lombok.Getter;
import lombok.Setter;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.Room.Room;

import java.util.List;


//the class is responsible for description of the chosen run by user
@Getter
@Setter
public class Location {

    protected LocationType locType;

    protected List<Room> rooms;

    public Location(LocationType locType, List<Room> rooms){
        this.locType = locType;
        this.rooms = rooms;
    }
}
