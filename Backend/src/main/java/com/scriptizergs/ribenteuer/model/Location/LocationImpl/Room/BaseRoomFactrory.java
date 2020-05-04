package com.scriptizergs.ribenteuer.model.Location.LocationImpl.Room;

import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public abstract class BaseRoomFactrory {

    public abstract Room generateRoom(LocationType locType, RoomType roomType, int characterLvl);

}
