package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Item.ItemFactoryImpl;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public class Rack extends InteractiveObject {

    public Rack(){
        this.name = "Rack";
        this.portraitId = "2";
        this.locationType = LocationType.CASTLEDUNGEON;
        results = new String[2];
        results[0] = "After examining the rack you notice a secret door." +
                " Behind it you find a nameholder";
        results[1] = "Having examined the rack you" +
                " do not notice anything useful";
    }

    @Override
    protected String interact(FightCharacter fightCharacter) {

        if(Math.random() < fightCharacter.getCurrentChar().getAgility() * 0.02){
            ItemFactoryImpl itemFactory = new ItemFactoryImpl();
            itemFactory.createRandomItem(fightCharacter.getCurrentChar().getId());
            return results[0];
        }else{
            return results[1];
        }

    }

}
