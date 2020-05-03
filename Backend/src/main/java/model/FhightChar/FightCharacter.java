//developed by Vladyslav Haponenko
package model.FhightChar;

import lombok.Getter;
import lombok.Setter;
import model.Character.Abilty.Ability;
import model.Character.CharacterRepository;
import model.Character.CharacterService;
import model.Character.CharacterServiceImpl;
import model.Character.GameCharacter;
import model.Item.Item;
import model.Item.ItemRepository;
import model.Item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;


//the class is supposed to be like a wrapper for dungeon run of a character
@Getter
@Setter
public class FightCharacter {
    private double maxHealth;
    private double currentHealth;
    private double attackDmg;
    private double abilityDmg;
    private GameCharacter currentChar;

    @Autowired
    private CharacterServiceImpl characterService;

    public FightCharacter(GameCharacter character){
        currentChar=character;

        deactivateAllSkills();

        int strength=currentChar.getStrength();
        int intell=currentChar.getIntelligence();
        int agility=currentChar.getAgility();

        maxHealth=18*strength+4*intell;
        currentHealth=maxHealth;
        attackDmg=1.4*strength+0.5*intell;
        abilityDmg=1.3*intell + 0.3*strength;
    }

    public void turnPassed(){
        currentChar.turnPassed();
    }

    public void activateSkill(String name){
        currentChar.activateSkill(name);
    }

    public void deactivateSkill(String name){
        currentChar.deactivateSkill(name);
    }

    public double makePlainDmg(double targetHealth){
        double buff = attackDmg * collectDamageBuff();
        double dmg = (buff != 0 ? buff : attackDmg);
        selfHeal(dmg * collectVampirism());
        return dmg;
    }

    public double makeAbilityDmg(double targetHealth){
        double buff = abilityDmg * collectAbilityDamageBuff();
        double dmg = (abilityDmg * buff != 0 ? buff : abilityDmg);
        dmg += targetHealth * collectFinishingOffBuff();
        selfHeal(dmg * collectVampirism());
        return dmg;
    }

    public double makeHeal(){
        double healAmount = currentHealth * collectHealBuff();
        selfHeal(healAmount);
        return currentHealth * collectHealBuff();
    }

    public double take_dmg(double dmg){
        double avoidChance = collectAvoidChance();
        double armor = collectArmor();
        double newDmg = (Math.random() < avoidChance ? 0 : dmg * armor);
        currentHealth=(newDmg > currentHealth ? 0 : currentHealth-newDmg);

        return newDmg;
    }

    public void selfHeal(double heal){
        currentHealth= Math.min(currentHealth+heal,maxHealth);
    }


    private void deactivateAllSkills(){
        for(Ability ability: currentChar.getAbilities()){
           ability.setStartOptions();
        }
    }

    private double collectAvoidChance(){
        double avoidChance = 0;
        for(Ability ability : currentChar.getAbilities()){
            avoidChance += (ability.isActive() ? ability.multAvoidChance() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            avoidChance += item.getAvoidChance();
        }
        return avoidChance;
    }

    private double collectAbilityDamageBuff(){
        double abilityDamage = 0;
        for(Ability ability : currentChar.getAbilities()){
            abilityDamage += (ability.isActive() ? ability.multAbilityDamage() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            abilityDamage += item.multAbilityDamage();
        }
        return abilityDamage;
    }

    private double collectDamageBuff(){
        double damage = 0;
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            damage += item.multDamage();
        }
        return damage;
    }

    private double collectHealBuff(){
        double heal = 0;
        for(Ability ability : currentChar.getAbilities()){
            heal += (ability.isActive() ? ability.multHeal() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            heal += item.multHeal();
        }
        return heal;
    }

    private double collectArmor(){
        double armor = 1;
        for(Ability ability : currentChar.getAbilities()){
            armor -= (ability.isActive() ? ability.multDamageTaken() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            armor -= item.multDamageTaken();
        }
        return armor;
    }

    private double collectVampirism(){
        double vampirism = 0;
        for(Ability ability : currentChar.getAbilities()){
            vampirism += (ability.isActive() ? ability.multVampirism() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            vampirism += item.multVampirism();
        }
        return vampirism;
    }

    private double collectFinishingOffBuff(){
        double finishingOff = 0;
        for(Ability ability : currentChar.getAbilities()){
            finishingOff += (ability.isActive() ? ability.multFinishingOff() : 0);
        }
        for(Item item : characterService.takeAllEquipedItemsById(currentChar.getId())){
            finishingOff += item.getFinishingOff();
        }
        return finishingOff;
    }
}
