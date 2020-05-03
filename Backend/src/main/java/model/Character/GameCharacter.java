//developed by Vladyslav Haponenko
package model.Character;

import lombok.Getter;
import lombok.Setter;
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

    protected int portraitId;

    protected int freeStatPoints;

    protected int  freeSkillPoints;

    protected ClassesCategories classOfChar;

    protected List<Ability> abilities;


    public int calculateExpNeeded(){
        return lvl*100;
    }


    public GameCharacter(){
        freeSkillPoints = 0;
        freeStatPoints = 10;
    }

    public void activateSkill(String name){
        for(Ability ability : abilities){
            if(ability.abilityName().equals(name) && ability.activatable()){
                ability.activate();
                break;
            }
        }
    }

    public void deactivateSkill(String name){
        for(Ability ability : abilities){
            if(ability.abilityName().equals(name) && ability.isActive()){
                ability.deactivate();
                break;
            }
        }
    }

    public void turnPassed(){
        for(Ability ability : abilities){
            ability.turnPassed();
        }
    }

    public void addSkillPoitns(int skillPoints){
        this.freeStatPoints +=skillPoints;
    }

    public void addStatPoints(int statPoints){
        this.freeStatPoints += statPoints;
    }

    public void addAgility(int points){
        if(points <= this.freeStatPoints){
            this.agility += points;
        }
    }

    public void addStrength(int points){
        if(points <= this.freeStatPoints){
            this.strength += points;
        }
    }

    public void addIntelligence(int points){
        if(points <= this.freeStatPoints){
            this.intelligence += points;
        }
    }

    public void lvlUp(){
        lvl += 1;
        freeStatPoints += 5;
        freeSkillPoints += 1;
    }

    public void addExp(int exp){
        if(currentExp + exp >= this.expNeeded){
            currentExp = currentExp + exp - expNeeded;
            lvlUp();
        }else{
            currentExp += exp;
        }
    }



}
