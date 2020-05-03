package model.Location.LocationImpl.Room;

import model.Location.LocationImpl.LocationType;

public abstract class BaseRoomFactrory {

    public abstract Room generateRoom(LocationType locType, RoomType roomType, int characterLvl);

}
