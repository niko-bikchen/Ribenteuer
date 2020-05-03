//developed by Vladyslav Haponenko
package model.Character.Classes;

import model.Character.Abilty.Ability;
import model.Character.Abilty.RogueSkills.*;
import model.Character.GameCharacter;

import java.util.ArrayList;

import static model.Character.ClassesCategories.ROGUE;

public class Rogue extends GameCharacter {

    public Rogue(String ownerId,String name, int portraitId){
        super();
        this.currentExp=0;
        this.lvl=1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=17;
        this.intelligence=18;
        this.agility=25;
        this.expNeeded=calculateExpNeeded();

        this.classOfChar = ROGUE;

        this.portraitId = portraitId;

        abilities=new ArrayList<Ability>();
        abilities.add(new Concentration());
        abilities.add(new CunningAttack());
        abilities.add(new HailOfBlows());
        abilities.add(new IntombmentTrick());
        abilities.add(new Thrust());

    }

}
