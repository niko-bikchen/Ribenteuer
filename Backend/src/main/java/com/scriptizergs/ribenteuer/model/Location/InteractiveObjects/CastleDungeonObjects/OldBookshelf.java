package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.CastleDungeonObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public class OldBookshelf extends InteractiveObject {

    public OldBookshelf(){
        this.name = "Old bookshelf";
        this.portraitId = "1";
        this.locationType = LocationType.CASTLEDUNGEON;
        results = new String[2];
        results[0] = "Among the old books on this shelf," +
                " you will find several useful specimens" +
                " that could help you in understanding your craft." +
                " After spending some time reading, you gain valuable knowledge";
        results[1] = "Among the old books on this shelf," +
                " you will find several useful specimens that could help" +
                " you in understanding your craft. But unfortunately" +
                " the text of the books was too complicated and" +
                " can not teach you anything";
    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        if(Math.random() < fightCharacter.getCurrentChar().getIntelligence() * 0.02){
            fightCharacter.getCurrentChar().addExp(20);
            return results[0];
        }else{
            return results[1];
        }
    }


}
