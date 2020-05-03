package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.FhightChar.FightCharacter;
import model.Location.InteractiveObjects.InteractiveObject;
import model.Location.LocationImpl.LocationType;

public class ThePlaceOfRitual extends InteractiveObject {

    public ThePlaceOfRitual(){
        this.name = "The place of ritual";
        this.portraitId = "5";
        this.locationType = LocationType.CASTLEDUNGEON;
        results = new String[3];
        String exposition = "Looking at these stones," +
                " you notice that they were prepared to begin" +
                " a healing ritual. You decide to finish it and" +
                " restore your health";
        results[0] = exposition + "During the ritual, nothing bad happened and you feel better";
        results[1] = exposition + "During the ritual you made a terrible" +
                " mistake and instead of healing you were struck by a magic arrow";
        results[2] = "You do not notice anything interesting in these stones";
    }

    @Override
    protected String interact(FightCharacter fightCharacter) {
        if(Math.random() < fightCharacter.getCurrentChar().getIntelligence() * 0.02){
            if(Math.random() < fightCharacter.getCurrentChar().getIntelligence() * 0.03){
                fightCharacter.selfHeal(fightCharacter.getCurrentHealth() * 0.15);
                fightCharacter.getCurrentChar().addExp(15);
                return results[0];
            }else{
                fightCharacter.take_dmg(fightCharacter.getCurrentHealth() * 0.2);
                return results[1];
            }
        }else{
            return results[2];
        }
    }
}
