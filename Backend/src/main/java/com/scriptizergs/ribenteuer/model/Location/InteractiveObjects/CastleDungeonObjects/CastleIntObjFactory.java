package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects;

import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;

public class CastleIntObjFactory extends BaseCastleIntObjFactory {
    @Override
    public InteractiveObject getInteractiveObject(CastleInteractiveObjects intObj) {
        switch(intObj)
        {
            case RACK:
                return new Rack();
            case OLDBOOKSHELF:
                return new OldBookshelf();
            case STONEBLOCKAGE:
                return new StoneBlockage();
            case THEPLACEOFRITUAL:
                return new ThePlaceOfRitual();
            case THEHANDLEINTHEPILEOFSTONES:
                return new TheHandleInThePileOfStones();
        }
        return null;
    }

    @Override
    public InteractiveObject getRandomInteractiveObject() {
        return getInteractiveObject(CastleInteractiveObjects.values()
                [randomIndex(CastleInteractiveObjects.values().length)]);
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
