package com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.ForestObjects;

import com.scriptizergs.ribenteuer.model.FhightChar.FightCharacter;
import com.scriptizergs.ribenteuer.model.Location.InteractiveObjects.InteractiveObject;
import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;

public class BushWithBerries extends InteractiveObject {

    public BushWithBerries(){
        this.name = "A bush with berries";
        this.portraitId = "3";
        this.locationType = LocationType.FOREST;
        results = new String[2];
        results[0] = "You decided to taste the berries from this bush." +
                " They turned out to be very nutritious." +
                " Now you are feeling better";
        results[1] = "You decided to taste the berries from this bush." +
                " They were terribly bitter. You feel disgusting";
    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        if(Math.random() < 0.8){
            fightCharacter.selfHeal(fightCharacter.getCurrentHealth() * 0.1);
            return results[0];
        }else{
            fightCharacter.take_dmg(fightCharacter.getCurrentHealth() * 0.15);
            return results[1];
        }
    }
}
