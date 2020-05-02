//developed by Vladyslav Haponenko
package model.Character.Classes;

import model.Character.Abilty.Ability;
import model.Character.Abilty.RogueSkills.*;
import model.Character.GameCharacter;

import java.util.ArrayList;

public class Rogue extends GameCharacter {

    public Rogue(String ownerId,String name){
        this.currentExp=0;
        this.lvl=1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=17;
        this.intelligence=18;
        this.agility=25;
        this.expNeeded=calculateExpNeeded();

        this.classOfChar = "rogue";

        abilities=new ArrayList<Ability>();
        abilities.add(new Consentration());
        abilities.add(new CunningAttack());
        abilities.add(new HailOfBlows());
        abilities.add(new IntombmentTrick());
        abilities.add(new Thrust());

    }

}
