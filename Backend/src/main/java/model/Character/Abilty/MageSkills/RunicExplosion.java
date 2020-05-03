package model.Character.Abilty.MageSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;

public class RunicExplosion extends Ability {


    public RunicExplosion(){
        this.lvlOfAbil = 1;
        this.lvl = 1;
        this.abilityDamage = 1.15;
        this.cdTurns = 6;
        this.activityTurnsNum = 1;
        this.cdDeTurnsLef = 0;
        this.acTurnsLeft = 0;
        this.active = false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);

        description = "The player deals 115 \\ 130 \\" +
                " 145% damage from his ability damage. Cooldown — 6 rounds";
    }

    @Override
    public String abilityName() {
        return "runic explosion";
    }


    @Override
    public void upAbility() {
        abilityDamage += 0.15;
        lvlOfAbil += 1;

    }

}
