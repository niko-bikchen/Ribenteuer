//developed by Vladyslav Haponenko
package model.Character;

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
    }

}
