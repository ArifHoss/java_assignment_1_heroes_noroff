package org.example.pojos.heroes;

import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.enums.ArmorType.CLOTH;
import static org.example.enums.ArmorType.LEATHER;
import static org.example.enums.Slot.LEGS;
import static org.example.enums.Slot.WEAPON;
import static org.junit.jupiter.api.Assertions.*;

class RangerTest {


    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage("Gandalf");
    }

    @Test
    void createMage() {
        String actual = mage.getName();
        String expected = "Gandalf";
        assertEquals(expected, actual);
    }

    @Test
    void levelUp() {
        mage.levelUp();
        assertEquals(2, mage.getLevel());
    }

    @Test
    void damage() {
    }

    @Test
    void totalAttributes() {
    }

    /*
      Valid weapons
    • Rangers – Bow

      Valid armor
    • Rangers – Leather, Mail
     */
    @Test
    void equipValidWeapon() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Staff fo Testing", 1, WEAPON, WeaponType.STAFFS, 10);
        mage.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = mage.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Sword fo Testing", 1, WEAPON, WeaponType.SWORDS, 10);
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

}