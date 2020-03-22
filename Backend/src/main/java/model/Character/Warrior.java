//developed by Vladyslav Haponenko
package model.Character;


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
    }

}
