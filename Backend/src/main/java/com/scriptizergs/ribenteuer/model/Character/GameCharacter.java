//developed by Vladyslav Haponenko
package com.scriptizergs.ribenteuer.model.Character;

import lombok.Getter;
import lombok.Setter;
import com.scriptizergs.ribenteuer.model.Character.Abilty.Ability;
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

    protected double expToNextLevel;

    protected int level;

    protected int agility;

    protected int intelligence;

    protected int strength;

    protected int portraitId;

    protected int freeStatPoints;

    protected int freeSkillPoints;

    protected int gold;

    protected ClassesCategories characterClass;

    protected List<Ability> skills;


    public int calculateExpNeeded() {
        return level * 100;
    }


    public GameCharacter() {
        freeSkillPoints = 0;
        freeStatPoints = 10;
        gold = 100;
    }

    public void activateSkill(String name) {
        for (Ability ability : skills) {
            if (ability.abilityName().equals(name) && ability.activatable()) {
                ability.activate();
                break;
            }
        }
    }

    public void deactivateSkill(String name) {
        for (Ability ability : skills) {
            if (ability.abilityName().equals(name) && ability.isActive()) {
                ability.deactivate();
                break;
            }
        }
    }

    public void turnPassed() {
        for (Ability ability : skills) {
            ability.turnPassed();
        }
    }

    public void addSkillPoitns(int skillPoints) {
        this.freeStatPoints += skillPoints;
    }

    public void addStatPoints(int statPoints) {
        this.freeStatPoints += statPoints;
    }

    public void addAgility(int points) {
        if (points <= this.freeStatPoints) {
            this.agility += points;
        }
    }

    public void addStrength(int points) {
        if (points <= this.freeStatPoints) {
            this.strength += points;
        }
    }

    public void addIntelligence(int points) {
        if (points <= this.freeStatPoints) {
            this.intelligence += points;
        }
    }

    public void lvlUp() {
        level += 1;
        freeStatPoints += 5;
        freeSkillPoints += 1;
    }

    public void addExp(int exp) {
        if (currentExp + exp >= this.expToNextLevel) {
            currentExp = currentExp + exp - expToNextLevel;
            lvlUp();
        } else {
            currentExp += exp;
        }
    }

    public void addGold(int gold) {
        this.gold += Math.abs(gold);
    }

    public boolean isEnoughGold(int cost) {
        return gold >= cost;
    }

    public void spendGold(int gold) {
        if (isEnoughGold(gold)) {
            this.gold -= gold;
        }
    }


}
