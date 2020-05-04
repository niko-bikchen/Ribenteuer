package com.scriptizergs.ribenteuer.model.Character.Abilty.MageSkills;

import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static com.scriptizergs.ribenteuer.model.Mechanics.MechanicsCategory.ARMOR;

public class StoneArmor extends Ability {

    private double defenseMult;

    public StoneArmor(){
        this.lvlOfAbil = 1;
        this.lvl = 1;
        this.damageTaken = 0.7;
        this.cdTurns = 7;
        this.activityTurnsNum = 3;
        this.cdDeTurnsLef = 0;
        this.acTurnsLeft = 0;
        this.active = false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ARMOR);

        description = "Over 3 rounds, the player receives an additional 30 \\ 45" +
                " \\ 60% defense against enemy attacks. Cooldown — 7 rounds";
    }

    @Override
    public String abilityName() {
        return "stone armor";
    }


    @Override
    public void upAbility() {
        damageTaken -= 0.15;
        lvlOfAbil += 1;
    }

}
