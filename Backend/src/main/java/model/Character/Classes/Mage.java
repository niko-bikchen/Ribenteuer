//developed by Vladyslav Haponenko
package model.Character.Classes;

import model.Character.Abilty.Ability;
import model.Character.Abilty.MageSkills.*;
import model.Character.GameCharacter;

import java.util.ArrayList;

public class Mage extends GameCharacter {

    public Mage(String ownerId,String name){
        this.currentExp=0;
        this.lvl=1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=14;
        this.intelligence=28;
        this.agility=18;
        this.expNeeded=calculateExpNeeded();

        this.classOfChar = "mage";

        abilities=new ArrayList<Ability>();
        abilities.add(new FieryBlizzard());
        abilities.add(new MagicalVampirism());
        abilities.add(new RunicExplosion());
        abilities.add(new StoneArmor());
        abilities.add(new ArcaneBlur());

    }
}
