package model.Location.Monsters;

import lombok.Getter;
import lombok.Setter;
import model.Location.LocationImpl.LocationType;

@Getter
@Setter
public abstract class Monster {

    protected String portraitId;

    protected String name;

    protected double health;

    protected double maxDamage;

    protected double minDamage;

    protected LocationType locType;

    public boolean isAlive(){
        return health > 0;
    }

    public void takeDamage(double damage){
        health -= damage;
    }

    public double makeDamage(){
        return (Math.random() * ((maxDamage - minDamage) + 1)) + minDamage;
    }

    public double expFromMonster(int lvlOfChar){
        return 40 * 20 * lvlOfChar;
    }
}
