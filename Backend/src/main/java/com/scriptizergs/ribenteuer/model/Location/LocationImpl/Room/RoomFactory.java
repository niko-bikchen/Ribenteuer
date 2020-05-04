package com.scriptizergs.ribenteuer.model.Location.LocationImpl.Room;

import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects.BaseCastleIntObjFactory;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects.CastleIntObjFactory;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects.CastleInteractiveObjects;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects.BaseForestObjFactory;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects.ForestInteractiveObjects;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects.ForestObjFactory;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import com.scriptizergs.ribenteuer.model.Location.Monsters.CastleDungeonMonsters.Fantom;
import com.scriptizergs.ribenteuer.model.Location.Monsters.CastleDungeonMonsters.Skeleton;
import com.scriptizergs.ribenteuer.model.Location.Monsters.ForestMonsters.Cutthroat;
import com.scriptizergs.ribenteuer.model.Location.Monsters.ForestMonsters.Wolf;
import com.scriptizergs.ribenteuer.model.Location.Monsters.Monster;

import java.util.LinkedList;
import java.util.List;

public class RoomFactory extends BaseRoomFactrory {


    @Override
    public Room generateRoom(LocationType locType, RoomType roomType, int characterLvl) {
        switch(roomType)
        {
            case INTERACTIVE:
                return new Room(locType, roomType,
                            null, generateIntObjects(locType) );
                case FIGHT:
                return new Room(locType, roomType,
                        createRandomMonster(characterLvl, locType), null );
        }
        return null;
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

    private Monster createRandomMonster(int characterLvl, LocationType locType){
        double ods = Math.random();
        switch(locType)
        {
            case FOREST:
                if(ods < 0.5){
                    return new Cutthroat(characterLvl);
                }else{
                    return new Wolf(characterLvl);
                }
            case CASTLEDUNGEON:
                if(ods < 0.5){
                    return new Skeleton(characterLvl);
                }else{
                    return new Fantom(characterLvl);
                }

        }
        return null;
    }


    private List<InteractiveObject> generateIntObjects(LocationType locType){
        List<InteractiveObject> list = new LinkedList<InteractiveObject>();
        int quantity = 0;
        switch (locType)
        {
            case CASTLEDUNGEON:
                 quantity = randomIndex(CastleInteractiveObjects.values().length) + 1;
                 BaseCastleIntObjFactory factory = new CastleIntObjFactory();
                 for(int i = 0; i < quantity ; i++){
                     list.add(factory.getRandomInteractiveObject());
                 }
                 break;
            case FOREST:
                quantity = randomIndex(ForestInteractiveObjects.values().length) + 1;
                BaseForestObjFactory factor = new ForestObjFactory();
                for(int i = 0; i < quantity ; i++){
                    list.add(factor.getRandomInteractiveObject());
                }
                break;
        }
        return list;
    }


}
