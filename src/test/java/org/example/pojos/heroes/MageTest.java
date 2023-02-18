package org.example.pojos.heroes;

import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.example.enums.ArmorType.CLOTH;
import static org.example.enums.ArmorType.LEATHER;
import static org.example.enums.Slot.LEGS;
import static org.example.enums.Slot.WEAPON;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Mage mage;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        mage = new Mage("Gandalf");
    }

    @Test
    void createMage() {
        //Arrange
        String actual = mage.getName();
        //Act
        String expected = "Gandalf";
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUp() {
        //Arrange
        mage.levelUp();
        //Act
        int actual = mage.getLevel();
        //Assert
        assertEquals(2, actual);
    }


    @Test
    public void testDamageWithValidWeapon() throws InvalidWeaponException {
        Weapon expectedWeapon = new Weapon("Staff fo Testing", 1, WEAPON, WeaponType.STAFFS, 2.0);
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
        Weapon expectedWeapon = new Weapon("Staff", 1, WEAPON, WeaponType.STAFFS, 10);
        mage.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = mage.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidMageWeaponWand() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Wand", 1, WEAPON, WeaponType.WANDS, 10);
        mage.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = mage.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Sword", 1, WEAPON, WeaponType.SWORDS, 10);
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