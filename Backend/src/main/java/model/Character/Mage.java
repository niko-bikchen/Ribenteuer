//developed by Vladyslav Haponenko
package model.Character;

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
    }
}
