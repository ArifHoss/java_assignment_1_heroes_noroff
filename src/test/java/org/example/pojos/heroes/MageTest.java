package org.example.pojos.heroes;

import org.example.enums.*;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.*;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Mage mage;
    private Weapon weapon;
    private Armor armor;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    /*
    Short descriptions of my Hero
    Gandalf: is a powerful wizard who is known for his wisdom and
    guidance to the heroes of the story. Gandalf is a key
    player in the defeat of 'Sauron' and the ultimate triumph
    of good over evil in Middle-earth. He is often depicted
    as an old man with a long beard and a tall pointed hat.
     */

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        mage = new Mage("Gandalf");
        weapon = new Weapon("Common Staff", 1, WEAPON, STAFFS);
        armor = new Armor("Common Cloth", 1, BODY, CLOTH);
    }

    @Test
    void createMageWithValidNameAndAttributes() {
        //Arrange
        String expectedName = "Gandalf";
        int expectedLevel = 1;
        HeroAttribute expectedAttributes = new HeroAttribute(1, 1, 8);
        //Act
        String actualName = mage.getName();
        int actualLevel = mage.getLevel();
        HeroAttribute actualAttributes = mage.getHeroAttributes();
        //Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedLevel,actualLevel);
        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    void levelUp() {
        //Arrange
        mage.levelUp(); // Level increase by 1, every time call levelUp() method.
        int expectedLevel = 2;
        HeroAttribute expectedAttributes = new HeroAttribute(2, 2, 13);
        //Act
        int actualLevel = mage.getLevel();
        HeroAttribute actualAttributes = mage.getHeroAttributes();
        //Assert
        assertEquals(expectedLevel, actualLevel);
        assertEquals(expectedAttributes, actualAttributes);
    }
    /*
    * attribute gain
      A Mage begins at level 1 with:
      Strength Dexterity Intelligence
          1        1          8

      Every time a Mage levels up, they gain:
      Strength Dexterity Intelligence
         1         1         5
     */

    @Test
    void mageBaseAttributes() {
        //Arrange
        int expectedStrength = 1;
        int expectedDexterity = 1;
        int expectedIntelligence = 8;
        //Act
        int actualStrength = mage.getHeroAttributes().getStrength();
        int actualDexterity = mage.getHeroAttributes().getDexterity();
        int actualIntelligence = mage.getHeroAttributes().getIntelligence();
        //Assert
        assertEquals(expectedStrength,actualStrength);
        assertEquals(expectedDexterity,actualDexterity);
        assertEquals(expectedIntelligence,actualIntelligence);
    }

    @Test
    void calculateTotalAttributesWhileLevelUp() {
        //Arrange
        HeroAttribute expectedAttributes = new HeroAttribute(2, 2, 13);
        mage.levelUp();
        //Act
        HeroAttribute actualAttributes = mage.getHeroAttributes();
        //Assert
        assertEquals(expectedAttributes,actualAttributes);
    }

    /*
      Valid Weapon
    • Mages – Staff, Wand
      Valid Armor
    • Mages – Cloth
     */

    @Test
    void validWeaponName() {
        //Arrange
        String expectedWeaponName = "Common Staff";
        //Act
        String actualWeaponName = weapon.getName();
        //Assert
        assertEquals(expectedWeaponName,actualWeaponName);
    }
    @Test
    void validWeaponLevel() {
        //Arrange
        int expectedRequiredLevel = 1;
        //Act
        int actualRequiredLevel = weapon.getRequiredLevel();
        //Assert
        assertEquals(expectedRequiredLevel,actualRequiredLevel);
    }

    @Test
    void validWeaponSlot() {
        //Arrange
        Slot expectedSlot = WEAPON;
        //Act
        Slot actualSlot = weapon.getSlot();
        //Assert
        assertEquals(expectedSlot,actualSlot);
    }

    @Test
    void validWeaponType() {
        //Arrange
        WeaponType expectedWeaponType = STAFFS;
        //Act
        WeaponType actualWeaponType = weapon.getWeaponType();
        //Assert
        assertEquals(expectedWeaponType,actualWeaponType);
    }

    @Test
    void calculateDamageWithoutEquipment() {
        //Arrange
        mage.setHeroAttributes(new HeroAttribute(0, 0, 5));
        //Act
        double expectedDamage = (1.0 * (1 + mage.getHeroAttributes().getIntelligence() / 100.0));
        double actualDamage = mage.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage, 0.01);
    }

    @Test
    void calculateDamageWithValidWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        mage.setHeroAttributes(new HeroAttribute(0, 0, 5));
        weapon.setWeaponDamage(2.0);
        mage.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + mage.getHeroAttributes().getIntelligence() / 100.0));
        double actualDamage = mage.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    void calculateDamageWithReplacedWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        mage.setHeroAttributes(new HeroAttribute(0, 0, 5));
        weapon.setWeaponDamage(2.0);
        weapon = new Weapon("Common Staff", 1, WEAPON, STAFFS); // Replacing weapon
        mage.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + mage.getHeroAttributes().getIntelligence() / 100.0));
        double actualDamage = mage.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }
    @Test
    void calculateDamageWithValidWeaponAndArmorEquipped() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        weapon = new Weapon("Common Wand", 1, Slot.WEAPON, WANDS);

        mage.setHeroAttributes(new HeroAttribute(0, 1, 5));
        weapon.setWeaponDamage(2.0);
        mage.equip(Slot.WEAPON, weapon);

        armor = new Armor("Common Cloth", 1, Slot.BODY, CLOTH);
        armor.setArmorAttribute(new HeroAttribute(0, 1, 2));
        mage.equip(Slot.BODY, armor);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * (1 + ((mage.getHeroAttributes().getIntelligence() + armor.getArmorAttribute().getIntelligence()) / 100.0));
        double actualDamage = MageTest.this.mage.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage,0.1);
    }
    @Test
    void equipValidMageWeaponStaffs() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Staff", 1, WEAPON, WeaponType.STAFFS);
        mage.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = mage.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidMageWeaponWand() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Wand", 1, WEAPON, WeaponType.WANDS);
        mage.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = mage.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Sword", 1, WEAPON, WeaponType.SWORDS);
        String expected = "Weapon type is not allowed for this character";

        //Act
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> mage.equip(WEAPON, expectedWeapon));
        String actual = weaponException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void equipValidArmor() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Cloth to Testing", 1, LEGS, CLOTH, new HeroAttribute(1, 1, 8));
        mage.equip(LEGS, expectedArmor);

        //Act
        Item actualArmor = mage.getEquipment().get(LEGS);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipInvalidArmor() {

        //Arrange
        Armor expectedArmor = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute(1, 1, 8));
        String expected = "Armor type is not allowed for this character";

        //Act
        Exception armorException = assertThrows(InvalidArmorException.class, () -> mage.equip(LEGS, expectedArmor));
        String actual = armorException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

    private static String getOutput() {
        return outContent.toString().trim();
    }

}