package model.Location.Monsters;

import lombok.Getter;
import lombok.Setter;
import model.Location.LocationType;

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
}
