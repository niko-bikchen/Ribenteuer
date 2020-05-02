package model.Location.Monsters.ForestMonsters;

import model.Location.LocationImpl.LocationType;
import model.Location.Monsters.Monster;

public class Wolf extends Monster {

    public Wolf(int charLvl){
        this.portraitId = "2";
        this.name = "Wolf";
        this.minDamage =  5 * 0.5 * charLvl;
        this.maxDamage = 13 * 0.7 * charLvl;
        this.health = 30 + charLvl * 10;
        this.locType = LocationType.FOREST;
    }
}
