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

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.AXES;
import static org.example.enums.WeaponType.HAMMERS;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Warrior warrior;
    private Weapon weapon;
    private Armor armor;

    /*
    Short descriptions of my Hero!
    Ragnar: A fierce and cunning warrior,
    who is also a skilled navigator and leader of men,
    known for his bravery and cunning tactics on the battlefield.
     */

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Ragnar");
        //Valid warrior weapon
        weapon = new Weapon("Axe", 1, WEAPON, AXES);
        //Valid warrior armor
        armor = new Armor("Mail");
    }

    @Test
    void createWarrior() {
        //Arrange
        String expectedName = "Ragnar";
        int expectedLevel = 1;
        HeroAttribute expectedAttributes = new HeroAttribute(5, 2, 1);

        //Act
        String actualName = warrior.getName();
        int actualLevel = warrior.getLevel();
        HeroAttribute actualAttributes = warrior.getHeroAttributes();
        //Assert
        assertEquals(expectedName,actualName);
        assertEquals(expectedLevel,actualLevel);
        assertEquals(expectedAttributes,actualAttributes);
    }

    @Test
    void levelUp() {
        //Arrange
        warrior.levelUp();
        int expectedLevel = 2;
        HeroAttribute expectedAttributes = new HeroAttribute(8, 4, 2);
        //Act
        int actualLevel = warrior.getLevel();
        HeroAttribute actualAttributes = warrior.getHeroAttributes();
        //Assert
        assertEquals(expectedLevel, actualLevel);
        assertEquals(expectedAttributes, actualAttributes);
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
    void validWeaponName() {
        //Arrange
        String expectedWeaponName = "Axe";
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
        WeaponType expectedWeaponType = AXES;
        //Act
        WeaponType actualWeaponType = weapon.getWeaponType();
        //Assert
        assertEquals(expectedWeaponType,actualWeaponType);
    }
    @Test
    void calculateDamageWithoutEquipment() {
        //Arrange
        warrior.setHeroAttributes(new HeroAttribute(5, 0, 0));
        //Act
        double expectedDamage = (1.0 * (1 + warrior.getHeroAttributes().getStrength() / 100.0));
        double actualDamage = warrior.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage, 0.01);
    }

    @Test
    void calculateDamageWithValidWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        warrior.setHeroAttributes(new HeroAttribute(5, 0, 0));
        weapon.setWeaponDamage(2.0);
        warrior.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + warrior.getHeroAttributes().getStrength() / 100.0));
        double actualDamage = warrior.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    void calculateDamageWithReplacedWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        warrior.setHeroAttributes(new HeroAttribute(5, 0, 0));
        weapon.setWeaponDamage(2.0);
        weapon = new Weapon("Hummer", 1, WEAPON, HAMMERS); // Replacing weapon
        warrior.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + warrior.getHeroAttributes().getStrength() / 100.0));
        double actualDamage = warrior.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }
    @Test
    void calculateDamageWithValidWeaponAndArmorEquipped() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        Warrior warrior = new Warrior("Conan");
        warrior.setHeroAttributes(new HeroAttribute(5, 1, 0));
        Weapon weapon = new Weapon("Common Axe", 1, Slot.WEAPON, AXES);
        weapon.setWeaponDamage(2.0);
        warrior.equip(Slot.WEAPON, weapon);
        Armor armor = new Armor("Common Plate Chest", 1, Slot.BODY, PLATE);
        armor.setArmorAttribute(new HeroAttribute(1, 0, 0));
        warrior.equip(Slot.BODY, armor);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * (1 + ((warrior.getHeroAttributes().getStrength() + armor.getArmorAttribute().getStrength()) / 100.0));
        double actualDamage = warrior.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage,0.1);
    }

    @Test
    void calculateDamageWithWeapon() throws InvalidWeaponException {
        //Arrange
        warrior.setHeroAttributes(new HeroAttribute(5, 0, 0));
        warrior.equip(WEAPON, weapon); //Equip the warrior with the weapon
        //Act
        double expectedDamage = (weapon.getWeaponDamage() * (1 + warrior.getHeroAttributes().getStrength() / 100.0));
        double actualDamage = warrior.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage, 0.01);
    }

    @Test
    void equipValidWarriorWeaponAxes() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Axe", 1, WEAPON, WeaponType.AXES);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipValidWarriorWeaponHammer() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Hammers", 1, WEAPON, WeaponType.HAMMERS);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }
    @Test
    void equipValidWarriorWeaponSword() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Swords", 1, WEAPON, WeaponType.SWORDS);
        warrior.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = warrior.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Bows", 1, WEAPON, WeaponType.BOWS);
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