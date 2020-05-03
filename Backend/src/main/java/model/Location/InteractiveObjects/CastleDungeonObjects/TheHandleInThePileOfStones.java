package model.Location.InteractiveObjects.CastleDungeonObjects;

import model.FhightChar.FightCharacter;
import model.Item.ItemFactoryImpl;
import model.Location.InteractiveObjects.InteractiveObject;
import model.Location.LocationImpl.LocationType;

public class TheHandleInThePileOfStones extends InteractiveObject {

    public TheHandleInThePileOfStones(){
        this.name = "The handle in the pile of stones";
        this.portraitId = "4";
        this.locationType = LocationType.CASTLEDUNGEON;
        results = new String[2];
        results[0] = "You notice the handle of some weapon sticking" +
                " out of a pile of stones. With some effort, you" +
                " pull it out and get a nameholder";
        results[1] = "You notice the hilt of some weapon sticking" +
                " out of a pile of stones. With some effort," +
                " you could not even move some of these stones." +
                " You decide to quit this activity";
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
