package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects;

import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;

public class ForestObjFactory extends BaseForestObjFactory {
    @Override
    public InteractiveObject getInteractiveObject(ForestInteractiveObjects intObj) {
        switch(intObj)
        {
            case BUSHWITHBERRIES:
                return new BushWithBerries();
            case LAWNWITHGRASS:
                return new LawnWithGrass();
            case LAWNWITHRABBIT:
                return new LawnWithRabbit();
            case STONEWITHNOTES:
                return new StoneWithNotes();
            case TRAPWITHPREY:
                return new TrapWithPrey();
        }
        return null;
    }

    @Override
    public InteractiveObject getRandomInteractiveObject() {
        return getInteractiveObject(ForestInteractiveObjects.values()
                [randomIndex(ForestInteractiveObjects.values().length)]);
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
