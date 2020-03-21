//developed by Vladyslav Haponenko
package model.FhightChar;

import lombok.Getter;
import lombok.Setter;
import model.Character.GameCharacter;


//the class is supposed to be like a wrapper for dungeon run of a character
@Getter
@Setter
public class FightCharacter {
    private double maxHealth;
    private double currentHealth;
    private double attackDmg;
    private double abilityDmg;
    private GameCharacter currentChar;

    public FightCharacter(GameCharacter character){
        currentChar=character;
        int strength=currentChar.getStrength();
        int intell=currentChar.getIntelligence();
        int agility=currentChar.getAgility();

        maxHealth=18*strength+4*intell;
        currentHealth=maxHealth;
        attackDmg=1.4*strength+0.5*intell;
        abilityDmg=1.3*intell + 0.3*strength;
    }

    public int makePlainDmg(){
        return 0;
    }

    public int makeAbilityDmg(){
        return 0;
    }

    public int makeHeal(){
        return 0;
    }

    public void take_dmg(int dmg){
        currentHealth=(dmg > currentHealth ? 0 : currentHealth-dmg);
    }

    public void selfHeal(int heal){
        currentHealth= Math.min(currentHealth+heal,maxHealth);
    }
}
