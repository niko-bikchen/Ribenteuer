package model.Location.LocationImpl;

import model.Character.GameCharacter;
import model.Location.LocationImpl.BaseLocationFactory;
import model.Location.LocationImpl.Location;
import model.Location.LocationImpl.Room.BaseRoomFactrory;
import model.Location.LocationImpl.Room.Room;
import model.Location.LocationImpl.Room.RoomFactory;
import model.Location.LocationImpl.Room.RoomType;

import java.util.LinkedList;
import java.util.List;

public class LocationFactory extends BaseLocationFactory {


    @Override
    public Location generateLocation(GameCharacter gameCharacter, LocationType locType) {
        return new Location(locType, generateRooms(locType, gameCharacter.getLvl()));
    }


    private List<Room> generateRooms(LocationType locationType, int charLvl){
        List<Room> list = new LinkedList<Room>();
        BaseRoomFactrory roomFactrory = new RoomFactory();
        for(int i = 0; i < 5 ; i++){
            list.add(roomFactrory.generateRoom(locationType, getRandomRoomType(), charLvl));
        }
        return list;
    }


    private RoomType getRandomRoomType(){
        return RoomType.values()[randomIndex(RoomType.values().length)];
    }


    private int randomIndex(int length){
        double range = 1 / length;
        int i = 1;
        double ods = Math.random();
        while( i * range < ods){
            i++;
        }
        return i - 1;
    }


}
