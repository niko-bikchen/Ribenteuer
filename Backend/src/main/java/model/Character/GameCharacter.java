//developed by Vladyslav Haponenko
package model.Character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Character.Abilty.Ability;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
public abstract class GameCharacter {

    @Id
    protected String id;

    protected String ownerId;

    protected String name;

    protected double currentExp;

    protected double expNeeded;

    protected int lvl;

    protected int agility;

    protected int intelligence;

    protected int strength;

    protected List<Ability> abilities;

    protected int calculateExpNeeded(){
        return lvl*100;
    }

}
