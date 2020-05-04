package model.Item;

import model.Character.ClassesCategories;
import model.Item.Categories.Categories;
import model.Item.Categories.LvlOfItem;
import model.Item.Items.Armors.Mage.AdeptsMantle;
import model.Item.Items.Armors.Mage.ApprenticesMantle;
import model.Item.Items.Armors.Mage.ArchimageMantle;
import model.Item.Items.Armors.Mage.BeginnersMantle;
import model.Item.Items.Armors.Rogue.BanditsArmor;
import model.Item.Items.Armors.Rogue.MaradeursArmor;
import model.Item.Items.Armors.Rogue.ShadowMasterArmor;
import model.Item.Items.Armors.Rogue.TweezersArmor;
import model.Item.Items.Armors.Warrior.ArmorMatesChainMail;
import model.Item.Items.Armors.Warrior.MasterSwordsmanCuirass;
import model.Item.Items.Armors.Warrior.PrenticesCuirass;
import model.Item.Items.Armors.Warrior.SwordsmansCuirass;
import model.Item.Items.Helmets.Mage.AdeptsHood;
import model.Item.Items.Helmets.Mage.ApprenticesHood;
import model.Item.Items.Helmets.Mage.ArchimageHood;
import model.Item.Items.Helmets.Mage.BeginnersHood;
import model.Item.Items.Helmets.Rogue.BanditsHood;
import model.Item.Items.Helmets.Rogue.MaradeursHat;
import model.Item.Items.Helmets.Rogue.ShadowMasterHat;
import model.Item.Items.Helmets.Rogue.TweezersHat;
import model.Item.Items.Helmets.Warrior.ArmorMatesHelmet;
import model.Item.Items.Helmets.Warrior.MasterSwordsmanHelmet;
import model.Item.Items.Helmets.Warrior.PrenticesHelmet;
import model.Item.Items.Helmets.Warrior.SwordsmansHelmet;
import model.Item.Items.Weapons.Mage.AdeptsStaff;
import model.Item.Items.Weapons.Mage.ApprenticesStaff;
import model.Item.Items.Weapons.Mage.ArchimageStaff;
import model.Item.Items.Weapons.Mage.BeginnersStaff;
import model.Item.Items.Weapons.Rogue.BanditsDagger;
import model.Item.Items.Weapons.Rogue.MaradeursDagger;
import model.Item.Items.Weapons.Rogue.ShadowMasterDagger;
import model.Item.Items.Weapons.Rogue.TweezersDagger;
import model.Item.Items.Weapons.Warrior.ArmorMatesSaber;
import model.Item.Items.Weapons.Warrior.MasterSwordsmansaber;
import model.Item.Items.Weapons.Warrior.PrenticesSaber;
import model.Item.Items.Weapons.Warrior.SwordsmansSaber;

public class ItemFactoryImpl extends BaseItemFactory {


    @Override
    public Item createItem(ClassesCategories typeOfChar, Categories typeOfItem, LvlOfItem lvlOfStrength, String charId) {
        Item item = null;
        switch (typeOfChar)
        {
            case ROGUE:
                switch (typeOfItem)
                {
                    case HELMET:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new TweezersHat(charId);
                                break;
                            case APPRENTICE:
                                item = new BanditsHood(charId);
                                break;
                            case ADEPT:
                                item = new MaradeursHat(charId);
                                break;
                            case MASTER:
                                item = new ShadowMasterHat(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new TweezersDagger(charId);
                                break;
                            case APPRENTICE:
                                item = new BanditsDagger(charId);
                                break;
                            case ADEPT:
                                item = new MaradeursDagger(charId);
                                break;
                            case MASTER:
                                item = new ShadowMasterDagger(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new TweezersArmor(charId);
                                break;
                            case APPRENTICE:
                                item = new BanditsArmor(charId);
                                break;
                            case ADEPT:
                                item = new MaradeursArmor(charId);
                                break;
                            case MASTER:
                                item = new ShadowMasterArmor(charId);
                                break;
                        }
                        break;
                }
                break;
            case MAGE:
                switch (typeOfItem)
                {
                    case HELMET:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new BeginnersHood(charId);
                                break;
                            case APPRENTICE:
                                item = new ApprenticesHood(charId);
                                break;
                            case ADEPT:
                                item = new AdeptsHood(charId);
                                break;
                            case MASTER:
                                item = new ArchimageHood(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new BeginnersStaff(charId);
                                break;
                            case APPRENTICE:
                                item = new ApprenticesStaff(charId);
                                break;
                            case ADEPT:
                                item = new AdeptsStaff(charId);
                                break;
                            case MASTER:
                                item = new ArchimageStaff(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new BeginnersMantle(charId);
                                break;
                            case APPRENTICE:
                                item = new ApprenticesMantle(charId);
                                break;
                            case ADEPT:
                                item = new AdeptsMantle(charId);
                                break;
                            case MASTER:
                                item = new ArchimageMantle(charId);
                                break;
                        }
                        break;
                }
                break;
            case WARRIOR:
                switch (typeOfItem)
                {
                    case HELMET:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new ArmorMatesHelmet(charId);
                                break;
                            case APPRENTICE:
                                item = new PrenticesHelmet(charId);
                                break;
                            case ADEPT:
                                item = new SwordsmansHelmet(charId);
                                break;
                            case MASTER:
                                item = new MasterSwordsmanHelmet(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new ArmorMatesSaber(charId);
                                break;
                            case APPRENTICE:
                                item = new PrenticesSaber(charId);
                                break;
                            case ADEPT:
                                item = new SwordsmansSaber(charId);
                                break;
                            case MASTER:
                                item = new MasterSwordsmansaber(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case BEGGINER:
                                item = new ArmorMatesChainMail(charId);
                                break;
                            case APPRENTICE:
                                item = new PrenticesCuirass(charId);
                                break;
                            case ADEPT:
                                item = new SwordsmansCuirass(charId);
                                break;
                            case MASTER:
                                item = new MasterSwordsmanCuirass(charId);
                                break;
                        }
                        break;
                }
                break;
        }
        return item;
    }



    public  Item createRandomItem(String charId){
        ClassesCategories classType = ClassesCategories
                .values()[randomIndex(ClassesCategories.values().length)];
        Categories itemCategory = Categories
                .values()[randomIndex(Categories.values().length)];
        LvlOfItem lvlOfIndex = LvlOfItem.values()[randomIndex(LvlOfItem.values().length)];

        return createItem(classType, itemCategory, lvlOfIndex,charId);
    }


    private int randomIndex(int length){
        double range = 1 / length;
        int i = 1;
        double ods = Math.random();
        while( i * range < ods){
            i++;
        }
        return i - 1;
    }


}
