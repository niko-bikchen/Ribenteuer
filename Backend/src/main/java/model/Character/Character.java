//developed by Vladyslav Haponenko
package model.Character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Getter
@Setter
public abstract class Character {

    @Id
    protected String id;

    protected String ownerId;

    protected int agility;

    protected int intelligence;

    protected int strength;



}
