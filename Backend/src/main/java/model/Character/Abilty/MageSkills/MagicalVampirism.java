package model.Character.Abilty.MageSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.VAMPIRISM;

public class MagicalVampirism extends Ability {

    public MagicalVampirism(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.vampirism=0.6;
        this.cdTurns=10;
        this.activityTurnsNum=1;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(VAMPIRISM);

        description = "The player restores to himself 60 \\ 70 \\" +
                " 80% of the amount of health points lost by" +
                " the enemy. Cooldown — 10 rounds";
    }

    @Override
    public String abilityName() {
        return "magical vampirism";
    }


    @Override
    public void upAbility() {
        vampirism += 0.1;
        lvlOfAbil += 1;
    }

}
