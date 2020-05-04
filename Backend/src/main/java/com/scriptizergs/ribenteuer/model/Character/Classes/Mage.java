//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Character.Classes;

import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
import com.scriptizergs.ribenteuer.model.Character.Abilty.MageSkills.*;
import com.scriptizergs.ribenteuer.model.Character.ClassesCategories;
import com.scriptizergs.ribenteuer.model.Character.GameCharacter;

import java.util.ArrayList;

public class Mage extends GameCharacter {

    public Mage(String ownerId,String name, int portraitId){
        super();
        this.currentExp=0;
        this.level =1;
        this.name=name;
        this.ownerId=ownerId;
        this.strength=14;
        this.intelligence=28;
        this.agility=18;
        this.expToNextLevel =calculateExpNeeded();

        this.characterClass = ClassesCategories.MAGE;

        this.portraitId = portraitId;

        skills =new ArrayList<Ability>();
        skills.add(new FieryBlizzard());
        skills.add(new MagicalVampirism());
        skills.add(new RunicExplosion());
        skills.add(new StoneArmor());
        skills.add(new ArcaneBlur());

    }
}
