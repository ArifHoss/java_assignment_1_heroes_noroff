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
import static org.example.enums.Slot.LEGS;
import static org.example.enums.Slot.WEAPON;
import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    private Rogue rogue;

    @BeforeEach
    void setUp() {
        rogue = new Rogue("Gandalf");
    }

    @Test
    void createRogue() {
        String actual = rogue.getName();
        String expected = "Gandalf";
        assertEquals(expected, actual);
    }

    @Test
    void levelUp() {
        rogue.levelUp();
        assertEquals(2, rogue.getLevel());
    }

    @Test
    void damage() {
    }

    @Test
    void totalAttributes() {
    }

    /*
      Valid weapons
    • Rogues – Dagger, Sword

      Valid armor
    • Rogues – Leather, Mail
     */
    @Test
    void equipValidRogueWeaponDagger() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Dagger", 1, WEAPON, WeaponType.DAGGERS, 10);
        rogue.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = rogue.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidRogueWeaponSword() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Swords", 1, WEAPON, WeaponType.SWORDS, 10);
        rogue.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = rogue.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidRWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Staff", 1, WEAPON, WeaponType.STAFFS, 10);
        String expected = "Weapon type is not allowed for this character";

        //Act
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> rogue.equip(WEAPON, expectedWeapon));
        String actual = weaponException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void equipValidRogueArmorLeather() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute(2, 6, 1));
        rogue.equip(LEGS, expectedArmor);

        //Act
        Item actualArmor = rogue.getEquipment().get(LEGS);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipValidRogueArmorMail() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Leather", 1, LEGS, MAIL, new HeroAttribute(2, 6, 1));
        rogue.equip(LEGS, expectedArmor);

        //Act
        Item actualArmor = rogue.getEquipment().get(LEGS);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipInvalidArmor() {

        //Arrange
        Armor expectedArmor = new Armor("Cloth", 1, LEGS, CLOTH, new HeroAttribute(2, 6, 1));
        String expected = "Armor type is not allowed for this character";

        //Act
        Exception armorException = assertThrows(InvalidArmorException.class, () -> rogue.equip(LEGS, expectedArmor));
        String actual = armorException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

}