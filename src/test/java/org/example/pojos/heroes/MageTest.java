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

import static org.example.enums.ArmorType.CLOTH;
import static org.example.enums.ArmorType.LEATHER;
import static org.example.enums.Slot.LEGS;
import static org.example.enums.Slot.WEAPON;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {
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
    4.1) Equipping weapons
    • Mages – Staff, Wand
    • Rangers – Bow
    • Rogues – Dagger, Sword
    • Warriors – Axe, Hammer, Sword

    4.2) Equipping armor
    Certain hero classes can equip certain armor types:
    • Mages – Cloth
    • Rangers – Leather, Mail
    • Rogues – Leather, Mail
    • Warriors – Mail, Plate
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
        Armor armorLeather = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute(1, 1, 8));


    }

}