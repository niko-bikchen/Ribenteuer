package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Item.ItemFactoryImpl;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public class StoneBlockage extends InteractiveObject {

    public StoneBlockage(){
        this.name = "Stone blockage";
        this.portraitId = "3";
        this.locationType = LocationType.CASTLEDUNGEON;
        results = new String[2];
        results[0] = "You decided to remove stone blockages in" +
                " an attempt to find something useful." +
                " It’s not difficult for you to succeed," +
                " but it was worth it. Under the rubble you found a nameholder";
        results[1] = "You decided to remove stone blockages in" +
                " an attempt to find something useful." +
                " But heavy stones do not succumb to you." +
                " You decide to quit this business";
    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        if(Math.random() < fightCharacter.getCurrentChar().getStrength() * 0.03){
            ItemFactoryImpl itemFactory = new ItemFactoryImpl();
            itemFactory.createRandomItem(fightCharacter.getCurrentChar().getId());
            return results[0];
        }else{
            return results[1];
        }
    }


}
