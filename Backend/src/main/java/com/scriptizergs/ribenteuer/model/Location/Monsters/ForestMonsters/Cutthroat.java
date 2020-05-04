package com.scriptizergs.ribenteuer.model.Location.Monsters.ForestMonsters;

import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import com.scriptizergs.ribenteuer.model.Location.Monsters.Monster;

public class Cutthroat extends Monster {

    public Cutthroat(int charLvl){
        this.portraitId = "1";
        this.name = "Cutthroat";
        this.minDamage =  6 * 0.2 * charLvl;
        this.maxDamage = 10 * 0.4 * charLvl;
        this.health = 50 + charLvl * 5;
        this.locType = LocationType.FOREST;

    }
}
