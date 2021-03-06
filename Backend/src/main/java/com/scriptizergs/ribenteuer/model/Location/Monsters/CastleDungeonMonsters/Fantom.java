package com.scriptizergs.ribenteuer.model.Location.Monsters.CastleDungeonMonsters;

import com.scriptizergs.ribenteuer.model.Location.LocationImpl.LocationType;
import com.scriptizergs.ribenteuer.model.Location.Monsters.Monster;

public class Fantom extends Monster {

    public Fantom(int charLvl){
        this.portraitId = "4";
        this.name = "Fantom";
        this.minDamage =  6 * 0.2 * charLvl;
        this.maxDamage = 10 * 0.4 * charLvl;
        this.health = 50 + charLvl * 5;
        this.locType = LocationType.CASTLEDUNGEON;

    }

}
