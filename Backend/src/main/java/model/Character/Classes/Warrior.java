//developed by Vladyslav Haponenko
package model.Character.Classes;


import model.Character.Abilty.Ability;
import model.Character.Abilty.WarriorSkills.*;
import model.Character.ClassesCategories;
import model.Character.GameCharacter;

import java.util.ArrayList;

public class Warrior extends GameCharacter {

    public Warrior(String ownerId,String name, int portraitId){
        super();
        this.currentExp=0;
        this.level =1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=26;
        this.intelligence=14;
        this.agility=20;
        this.expToNextLevel =calculateExpNeeded();

        this.characterClass = ClassesCategories.WARRIOR;

        this.portraitId = portraitId;

        skills =new ArrayList<Ability>();
        skills.add(new Anger());
        skills.add(new BroadStroke());
        skills.add(new Courage());
        skills.add(new DefensiveStand());
        skills.add(new DestructiveStrike());
    }

}
