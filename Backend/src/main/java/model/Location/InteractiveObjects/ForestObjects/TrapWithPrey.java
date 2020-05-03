package model.Location.InteractiveObjects.ForestObjects;

import model.FhightChar.FightCharacter;
import model.Location.InteractiveObjects.InteractiveObject;
import model.Location.LocationImpl.LocationType;

public class TrapWithPrey extends InteractiveObject {

    public TrapWithPrey(){
        this.name = "Trap with prey";
        this.portraitId = "5";
        this.locationType = LocationType.FOREST;
        results = new String[2];
        results[0] = "Noticing the trap with the prey on the lawn," +
                " you decided to take the prey to yourself." +
                " You managed to neutralize the trap and now you have" +
                " a skin that you can sell in the city and get some ringing coins";
        results[1] = "Noticing the trap with the prey on the lawn," +
                " you decided to take the prey to yourself. You did not manage" +
                " to neutralize the trap and your hand does not look" +
                " better than the prey that was in this trap";

    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        double ods = fightCharacter.getCurrentChar().getAgility() * 0.03;
        if(Math.random() < ods){
            fightCharacter.getCurrentChar().addExp(10);
            fightCharacter.getCurrentChar().addGold(150);
            return results[0];
        }else{
            fightCharacter.take_dmg(fightCharacter.getCurrentHealth() * 0.15);
            return results[1];
        }
    }
}
