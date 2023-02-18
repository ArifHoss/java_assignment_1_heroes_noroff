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

class RangerTest {


    private Ranger ranger;


    /*
    Achilles: A legendary warrior, whose exceptional
    strength and fighting skills are matched only by
    his pride and arrogance, and whose exploits in
    battle are the stuff of legend.
     */
    @BeforeEach
    void setUp() {
        ranger = new Ranger("Achilles");
    }

    @Test
    void createRanger() {
        //Arrange
        String expectedName = "Achilles";
        int expectedLevel = 1;
        HeroAttribute expectedAttributes = new HeroAttribute(1, 7, 1);
        //Act
        String actualName = ranger.getName();
        int actualLevel = ranger.getLevel();
        HeroAttribute actualAttributes = ranger.getHeroAttributes();
        //Assert
        assertEquals(expectedName,actualName);
        assertEquals(expectedLevel,actualLevel);
        assertEquals(expectedAttributes,actualAttributes);
    }

    @Test
    void levelUp() {
        ranger.levelUp();
        assertEquals(2, ranger.getLevel());
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
    void equipValidRangerWeaponBows() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Bows", 1, WEAPON, WeaponType.BOWS, 10);
        ranger.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = ranger.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Sword", 1, WEAPON, WeaponType.SWORDS, 10);
        String expected = "Weapon type is not allowed for this character";

        //Act
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> ranger.equip(WEAPON, expectedWeapon));
        String actual = weaponException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void equipValidRangerArmorLeather() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Cloth", 1, LEGS, LEATHER, new HeroAttribute(1, 7, 1));
        ranger.equip(LEGS, expectedArmor);

        //Act
        Item actualArmor = ranger.getEquipment().get(LEGS);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipValidRangerArmorMail() throws InvalidArmorException {

        //Arrange
        Armor expectedArmor = new Armor("Cloth", 1, LEGS, MAIL, new HeroAttribute(1, 7, 1));
        ranger.equip(LEGS, expectedArmor);

        //Act
        Item actualArmor = ranger.getEquipment().get(LEGS);

        //Assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    void equipInvalidArmor() {

        //Arrange
        Armor expectedArmor = new Armor("Leather", 1, LEGS, CLOTH, new HeroAttribute(1, 7, 1));
        String expected = "Armor type is not allowed for this character";

        //Act
        Exception armorException = assertThrows(InvalidArmorException.class, () -> ranger.equip(LEGS, expectedArmor));
        String actual = armorException.getMessage();

        //Assert
        assertEquals(expected, actual);

    }

}