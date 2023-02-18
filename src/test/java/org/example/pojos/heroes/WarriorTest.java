package org.example.pojos.heroes;

import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Warrior warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Gandalf");
    }

    @Test
    void createWarrior() {
        String actual = warrior.getName();
        String expected = "Gandalf";
        assertEquals(expected, actual);
    }

    @Test
    void levelUp() {
        warrior.levelUp();
        assertEquals(2, warrior.getLevel());
    }

    @Test
    void dawarrior() {
    }

    @Test
    void totalAttributes() {
    }

    /*
      Valid weapons
    • Warriors – Axe, Hammer, Sword

      Valid armor
    • Warriors – Mail, Plate
     */
    @Test
    void equipValidWarriorWeaponAxes() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Axe", 1, WEAPON, WeaponType.AXES, 10);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidWarriorWeaponHammer() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Hammers", 1, WEAPON, WeaponType.HAMMERS, 10);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }
    @Test
    void equipValidWarriorWeaponSword() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Swords", 1, WEAPON, WeaponType.SWORDS, 10);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Bows", 1, WEAPON, WeaponType.BOWS, 10);
        String expected = "Weapon type is not allowed for this character";

        //Act
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> warrior.equip(WEAPON, expectedWeapon));
        String actual = weaponException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void equipWarriorValidArmorMail() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Mail", 1, BODY, MAIL, new HeroAttribute(5, 2, 1));
        warrior.equip(BODY, expectedArmor);

        //Act
        Item actualArmor = warrior.getEquipment().get(BODY);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipWarriorValidArmorPlate() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Plate", 1, BODY, PLATE, new HeroAttribute(5, 2, 1));
        warrior.equip(BODY, expectedArmor);

        //Act
        Item actualArmor = warrior.getEquipment().get(BODY);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }
    @Test
    void equipInvalidArmor() {

        //Arrange
        Armor expectedArmor = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute(5, 2, 1));
        String expected = "Armor level is too high for the character";

        //Act
        Exception armorException = assertThrows(InvalidArmorException.class, () -> warrior.equip(LEGS, expectedArmor));
        String actual = armorException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

}