package model.Character.Abilty.MageSkills;

import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.ARMOR;

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

    @Override
    public String description() {
        return null;
    }
}
