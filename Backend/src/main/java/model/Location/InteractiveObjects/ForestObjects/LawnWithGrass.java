package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class LawnWithGrass extends InteractiveObjects {

    public LawnWithGrass(){
        this.name = "Lawn with grass";
        this.portraitId = "2";
        this.locationType = LocationType.FOREST;
        results = new String[3];
        String exposition = "Looking around on the lawn you" +
                " notice a number of useful plants for your craft";
        results[0] = exposition + " After spending some time on this lawn," +
                " you have gathered a good handful of herbs, which you may be useful later";
        results[1] = exposition + "After spending some time on this lawn," +
                " you have gathered a good handful of herbs, which you may find useful later." +
                " Everything could have been good if you hadn’t " +
                "scratched your hands about the thorns growing nearby";
        results[2] = "Among the herbs on this lawn, you could not find anything useful";
    }


    @Override
    protected String interact(FightCharacter fightCharacter) {
        double ods = fightCharacter.getCurrentChar().getIntelligence() * 0.025;
        if(Math.random() < ods){
            if(Math.random() < fightCharacter.getCurrentChar().getAgility() * 0.03){
                fightCharacter.getCurrentChar().addExp(10);
                return results[0];
            }else{
                fightCharacter.getCurrentChar().addExp(100);
                fightCharacter.take_dmg(fightCharacter.getCurrentHealth() * 0.05);
                return results[1];
            }
        }
        return results[2];
    }
}
