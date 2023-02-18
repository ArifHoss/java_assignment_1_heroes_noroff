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

    /*
    Arthur: A chivalrous warrior with a strong sense
    of honor and justice, skilled in combat and known
    for his bravery on the battlefield.
     */

    @BeforeEach
    void setUp() {
        rogue = new Rogue("Arthur");
    }

    @Test
    void createRogue() {
        //Arrange
        String expectedName = "Arthur";
        int expectedLevel = 1;
        HeroAttribute expectedAttributes = new HeroAttribute(2,6,1);
        //Act
        String actualName = rogue.getName();
        int actualLevel = rogue.getLevel();
        HeroAttribute actualAttributes = rogue.getHeroAttributes();
        //assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedLevel, actualLevel);
        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    void levelUp() {
        //Arrange
        rogue.levelUp();
        int expectedLevel = 2;
        HeroAttribute expectedAttributes = new HeroAttribute(3, 10, 2);
        //Act
        int actualLevel = rogue.getLevel();
        HeroAttribute actualAttributes = rogue.getHeroAttributes();
        //Assert
        assertEquals(expectedLevel, actualLevel);
        assertEquals(expectedAttributes, actualAttributes);

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
        Weapon expectedWeapon = new Weapon("Dagger", 1, WEAPON, WeaponType.DAGGERS);
        rogue.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = rogue.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidRogueWeaponSword() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Swords", 1, WEAPON, WeaponType.SWORDS);
        rogue.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = rogue.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidRWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Staff", 1, WEAPON, WeaponType.STAFFS);
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