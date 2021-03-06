package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public class LawnWithRabbit extends InteractiveObject {

    public LawnWithRabbit(){
        this.name = "A lawn with a rabbit";
        this.portraitId = "4";
        this.locationType = LocationType.FOREST;
        results = new String[2];
        results[0] = "Noticing a rabbit on the lawn," +
                " you decide to hunt him." +
                " You succeeded and now after the adventure you can sell" +
                " his skin and get some ringing coins";
        results[1] = "Noticing a rabbit on the lawn," +
                " you decide to hunt him. You did not succeed and it ran away";
    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        double ods = fightCharacter.getCurrentChar().getAgility() * 0.03;
        if(Math.random() < ods){
            fightCharacter.getCurrentChar().addExp(10);
            fightCharacter.getCurrentChar().addGold(150);
            return results[0];
        }
        return results[1];
    }
}
