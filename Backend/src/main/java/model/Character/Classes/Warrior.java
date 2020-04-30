//developed by Vladyslav Haponenko
package model.Character.Classes;


import model.Character.Abilty.Ability;
import model.Character.Abilty.WarriorSkills.*;
import model.Character.GameCharacter;

import java.util.ArrayList;

public class Warrior extends GameCharacter {

    public Warrior(String ownerId,String name){
        this.currentExp=0;
        this.lvl=1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=26;
        this.intelligence=14;
        this.agility=20;
        this.expNeeded=calculateExpNeeded();

        this.classOfChar = "warrior";

        abilities=new ArrayList<Ability>();
        abilities.add(new Anger());
        abilities.add(new BroadStroke());
        abilities.add(new Courage());
        abilities.add(new DefensiveStand());
        abilities.add(new DestructiveStrike());
    }

}
