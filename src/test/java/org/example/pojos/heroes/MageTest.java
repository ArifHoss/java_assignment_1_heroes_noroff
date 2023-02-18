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
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Mage mage;
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


    @Test
    public void testDamageWithValidWeapon() throws InvalidWeaponException {
        Weapon expectedWeapon = new Weapon("Staff fo Testing", 1, WEAPON, WeaponType.STAFFS);
        mage.equip(Slot.WEAPON, expectedWeapon);
        mage.damage();
        assertEquals("Total Damage: 2.16", getOutput());
    }

    @Test
    void totalAttributes() {
    }

    /*
      Valid Weapon
    • Mages – Staff, Wand
      Valid Armor
    • Mages – Cloth
     */
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