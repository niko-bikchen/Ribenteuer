package model.Location.InteractiveObjects.ForestObjects;

import model.Character.GameCharacter;
import model.FhightChar.FightCharacter;
import model.Item.BaseItemFactory;
import model.Item.ItemFactoryImpl;
import model.Location.InteractiveObjects.InteractiveObjects;
import model.Location.LocationImpl.LocationType;

public class StoneWithNotes extends InteractiveObjects {

    public StoneWithNotes(){
        this.name = "Stone with notes";
        this.portraitId = "1";
        this.locationType = LocationType.FOREST;
        results = new String[3];
        String exposition = "Looking closely at the stone with notes" +
                " you notice that these are special signs of forest" +
                " robbers that they leave near their caches";
        results[0] = exposition + " Having found this cache, you quickly" +
                " neutralized the hidden trap and pick up the item" +
                " that was stored there";
        results[1] = exposition + " Having found this cache," +
                " you could not quickly neutralize the hidden trap," +
                " which led to the explosion of the bomb. You took damage," +
                " and a large stash scattered around";
        results[2] = "Marks on a stone do not tell you anything interesting";
    }

    @Override
    protected String interact(FightCharacter fightCharacter) {
        double ods = fightCharacter.getCurrentChar().getIntelligence() * 0.025;
        if(Math.random() < ods){
            if(Math.random() < fightCharacter.getCurrentChar().getAgility() * 0.03){
                BaseItemFactory itemFactory = new ItemFactoryImpl();
                itemFactory.createRandomItem(fightCharacter.getCurrentChar().getId());
                return results[0];
            }else{
                return results[1];
            }

        }
        return results[2];
    }

}
