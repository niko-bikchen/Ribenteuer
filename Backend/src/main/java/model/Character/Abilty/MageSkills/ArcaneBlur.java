package model.Character.Abilty.MageSkills;


import model.Character.Abilty.Ability;
import model.Mechanics.MechanicsCategory;

import java.util.LinkedList;

import static model.Mechanics.MechanicsCategory.AVOID;

public class ArcaneBlur extends Ability {

    public ArcaneBlur(){
        this.lvlOfAbil=1;
        this.lvl=2;
        this.avoidChance = 0.3;
        this.cdTurns=5;
        this.activityTurnsNum=2;
        this.cdDeTurnsLef=0;
        this.acTurnsLeft=0;
        this.active=false;

        this.types = new LinkedList<MechanicsCategory>();
        types.add(AVOID);

        description = "Over 3 rounds, the player increases" +
                " the probability of an enemy miss by 30 \\ 40" +
                " \\ 50%. Cooldown — 7 rounds";
    }

    @Override
    public String abilityName() {
        return "arcane blur";
    }


    @Override
    public void upAbility() {
        avoidChance +=0.1;
        lvlOfAbil += 1;
    }


}
