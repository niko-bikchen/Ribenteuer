package model.Item;

import model.Character.Classes.Mage;
import model.Character.Classes.Rogue;
import model.Character.Classes.Warrior;
import model.Character.ClassesCategories;
import model.Character.GameCharacter;
import model.Item.Categories.Categories;
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
    public Item createItem(ClassesCategories typeOfChar, Categories typeOfItem, int lvlOfStrength, String charId) {
        Item item = null;
        switch (typeOfChar)
        {
            case ROGUE:
                switch (typeOfItem)
                {
                    case HELMET:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new TweezersHat(charId);
                                break;
                            case 2:
                                item = new BanditsHood(charId);
                                break;
                            case 3:
                                item = new MaradeursHat(charId);
                                break;
                            case 4:
                                item = new ShadowMasterHat(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new TweezersDagger(charId);
                                break;
                            case 2:
                                item = new BanditsDagger(charId);
                                break;
                            case 3:
                                item = new MaradeursDagger(charId);
                                break;
                            case 4:
                                item = new ShadowMasterDagger(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new TweezersArmor(charId);
                                break;
                            case 2:
                                item = new BanditsArmor(charId);
                                break;
                            case 3:
                                item = new MaradeursArmor(charId);
                                break;
                            case 4:
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
                            case 1:
                                item = new BeginnersHood(charId);
                                break;
                            case 2:
                                item = new ApprenticesHood(charId);
                                break;
                            case 3:
                                item = new AdeptsHood(charId);
                                break;
                            case 4:
                                item = new ArchimageHood(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new BeginnersStaff(charId);
                                break;
                            case 2:
                                item = new ApprenticesStaff(charId);
                                break;
                            case 3:
                                item = new AdeptsStaff(charId);
                                break;
                            case 4:
                                item = new ArchimageStaff(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new BeginnersMantle(charId);
                                break;
                            case 2:
                                item = new ApprenticesMantle(charId);
                                break;
                            case 3:
                                item = new AdeptsMantle(charId);
                                break;
                            case 4:
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
                            case 1:
                                item = new ArmorMatesHelmet(charId);
                                break;
                            case 2:
                                item = new PrenticesHelmet(charId);
                                break;
                            case 3:
                                item = new SwordsmansHelmet(charId);
                                break;
                            case 4:
                                item = new MasterSwordsmanHelmet(charId);
                                break;
                        }
                        break;
                    case WEAPON:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new ArmorMatesSaber(charId);
                                break;
                            case 2:
                                item = new PrenticesSaber(charId);
                                break;
                            case 3:
                                item = new SwordsmansSaber(charId);
                                break;
                            case 4:
                                item = new MasterSwordsmansaber(charId);
                                break;
                        }
                        break;
                    case ARMORGARMENT:
                        switch (lvlOfStrength)
                        {
                            case 1:
                                item = new ArmorMatesChainMail(charId);
                                break;
                            case 2:
                                item = new PrenticesCuirass(charId);
                                break;
                            case 3:
                                item = new SwordsmansCuirass(charId);
                                break;
                            case 4:
                                item = new MasterSwordsmanCuirass(charId);
                                break;
                        }
                        break;
                }
                break;
        }
        return item;
    }


}
