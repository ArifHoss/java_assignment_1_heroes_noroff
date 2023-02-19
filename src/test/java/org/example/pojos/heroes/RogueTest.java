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
import static org.example.enums.WeaponType.*;
import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    private Rogue rogue;
    private Weapon weapon;
    private Armor armor;

    /*
    Arthur: A chivalrous warrior with a strong sense
    of honor and justice, skilled in combat and known
    for his bravery on the battlefield.
     */

    @BeforeEach
    void setUp() {
        rogue = new Rogue("Arthur");
        weapon = new Weapon("Common Dagger", 1, WEAPON, DAGGERS);
        armor = new Armor("Quality Leather", 1, BODY, LEATHER);
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


    /*
    * Rogue attribute gain
      A Rogue begins at level 1 with:
      Strength Dexterity Intelligence
          2        6          1

      Every time a Rogue levels up, they gain:
      Strength Dexterity Intelligence
         1         4         1
     */
    @Test
    void rogueBaseAttributes() {
        //Arrange
        int expectedStrength = 2;
        int expectedDexterity = 6;
        int expectedIntelligence = 1;
        //Act
        int actualStrength = rogue.getHeroAttributes().getStrength();
        int actualDexterity = rogue.getHeroAttributes().getDexterity();
        int actualIntelligence = rogue.getHeroAttributes().getIntelligence();
        //Assert
        assertEquals(expectedStrength,actualStrength);
        assertEquals(expectedDexterity,actualDexterity);
        assertEquals(expectedIntelligence,actualIntelligence);
    }
    @Test
    void calculateTotalAttributesWhileLevelUp() {
        //Arrange
        HeroAttribute expectedAttributes = new HeroAttribute(3, 10, 2);
        rogue.levelUp();
        //Act
        HeroAttribute actualAttributes = rogue.getHeroAttributes();
        //Assert
        assertEquals(expectedAttributes,actualAttributes);
    }

    /*
      Valid weapons
    • Rogues – Dagger, Sword

      Valid armor
    • Rogues – Leather, Mail
     */

    @Test
    void validWeaponName() {
        //Arrange
        String expectedWeaponName = "Common Dagger";
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
        WeaponType expectedWeaponType = DAGGERS;
        //Act
        WeaponType actualWeaponType = weapon.getWeaponType();
        //Assert
        assertEquals(expectedWeaponType,actualWeaponType);
    }

    @Test
    void calculateDamageWithoutEquipment() {
        //Arrange
        rogue.setHeroAttributes(new HeroAttribute(0, 5, 0));
        //Act
        double expectedDamage = (1.0 * (1 + rogue.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = rogue.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage, 0.01);
    }

    @Test
    void calculateDamageWithValidWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        rogue.setHeroAttributes(new HeroAttribute(0, 5, 0));
        weapon.setWeaponDamage(2.0);
        rogue.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + rogue.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = rogue.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    void calculateDamageWithReplacedWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        rogue.setHeroAttributes(new HeroAttribute(0, 2, 0));
        weapon.setWeaponDamage(2.0);
        weapon = new Weapon("Common Sword", 1, WEAPON, SWORDS); // Replacing weapon
        rogue.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + rogue.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = rogue.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }
    @Test
    void calculateDamageWithValidWeaponAndArmorEquipped() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        rogue.setHeroAttributes(new HeroAttribute(0, 2, 0));
        weapon.setWeaponDamage(2.0);
        rogue.equip(Slot.WEAPON, weapon);

        armor = new Armor("Common Mail", 1, Slot.BODY, MAIL);
        armor.setArmorAttribute(new HeroAttribute(0, 1, 2));
        rogue.equip(Slot.BODY, armor);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * (1 + ((rogue.getHeroAttributes().getDexterity() + armor.getArmorAttribute().getDexterity()) / 100.0));
        double actualDamage = rogue.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage,0.1);
    }
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