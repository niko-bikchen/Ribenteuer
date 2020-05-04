package com.scriptizergs.ribenteuer.model.Location.Monsters.CastleDungeonMonsters;

import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import com.scriptizergs.ribenteuer.model.Location.Monsters.Monster;

public class Skeleton extends Monster {

    public Skeleton(int charLvl){
        this.portraitId = "3";
        this.name = "Skeleton";
        this.minDamage =  5 * 0.4 * charLvl;
        this.maxDamage = 13 * 0.6 * charLvl;
        this.health = 40 + charLvl * 7;
        this.locType = LocationType.CASTLEDUNGEON;
    }

}
