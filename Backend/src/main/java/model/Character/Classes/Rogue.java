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
        this.level =1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=17;
        this.intelligence=18;
        this.agility=25;
        this.expToNextLevel =calculateExpNeeded();

        this.characterClass = ROGUE;

        this.portraitId = portraitId;

        skills =new ArrayList<Ability>();
        skills.add(new Concentration());
        skills.add(new CunningAttack());
        skills.add(new HailOfBlows());
        skills.add(new IntombmentTrick());
        skills.add(new Thrust());

    }

}
