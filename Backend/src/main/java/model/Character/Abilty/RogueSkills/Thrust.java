package model.Character.Abilty.RogueSkills;

import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ABILITY_DAMAGE;
import static model.Mechanics.MechanicsCategory.AVOID;

public class Thrust extends Ability {

    public Thrust(){
        this.lvlOfAbil=1;
        this.lvl=1;
        this.abilityDamage = 1.25;
        this.avoidChance = 0.2;
        this.cdTurns=5;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(ABILITY_DAMAGE);
        types.add(AVOID);

        description = "The player deals 125/150/175% damage" +
                " from his ability damage and increases enemy" +
                " miss chance by 10\\15\\20%. Cooldown — 5 rounds";
    }

    @Override
    public String abilityName() {
        return "thrust";
    }

    @Override
    public void upAbility() {
        abilityDamage += 0.25;
        avoidChance += 0.1;
        lvlOfAbil += 1;
    }

}
