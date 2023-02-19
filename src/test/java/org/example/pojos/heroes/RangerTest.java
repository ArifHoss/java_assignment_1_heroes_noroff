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

class RangerTest {


    private Ranger ranger;
    private Weapon weapon;
    private Armor armor;


    /*
    Achilles: A legendary warrior, whose exceptional
    strength and fighting skills are matched only by
    his pride and arrogance, and whose exploits in
    battle are the stuff of legend.
     */
    @BeforeEach
    void setUp() {
        ranger = new Ranger("Achilles");
        weapon = new Weapon("Common Bow", 1, WEAPON, BOWS);
        armor = new Armor("Quality Leather", 1, BODY, LEATHER);

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
        //Arrange
        ranger.levelUp();
        int expectedLevel = 2;
        HeroAttribute expectedAttributes = new HeroAttribute(2, 12, 2);
        //Act
        int actualLevel = ranger.getLevel();
        HeroAttribute actualAttributes = ranger.getHeroAttributes();
        //Assert
        assertEquals(expectedLevel,actualLevel);
        assertEquals(expectedAttributes,actualAttributes);
    }


    /*

      A Ranger begins at level 1 with:
      Strength Dexterity Intelligence
          1        7          1

      Every time a Ranger levels up, they gain:
      Strength Dexterity Intelligence
         1         5         1
     */
    @Test
    void rangerBaseAttributes() {
        //Arrange
        int expectedStrength = 1;
        int expectedDexterity = 7;
        int expectedIntelligence = 1;
        //Act
        int actualStrength = ranger.getHeroAttributes().getStrength();
        int actualDexterity = ranger.getHeroAttributes().getDexterity();
        int actualIntelligence = ranger.getHeroAttributes().getIntelligence();
        //Assert
        assertEquals(expectedStrength,actualStrength);
        assertEquals(expectedDexterity,actualDexterity);
        assertEquals(expectedIntelligence,actualIntelligence);
    }
    @Test
    void calculateTotalAttributesWhileLevelUp() {
        //Arrange
        HeroAttribute expectedAttributes = new HeroAttribute(2, 12, 2);
        ranger.levelUp();
        //Act
        HeroAttribute actualAttributes = ranger.getHeroAttributes();
        //Assert
        assertEquals(expectedAttributes,actualAttributes);
    }

    /*
      Valid weapons
    • Rangers – Bow

      Valid armor
    • Rangers – Leather, Mail
     */

    @Test
    void validWeaponName() {
        //Arrange
        String expectedWeaponName = "Common Bow";
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
        WeaponType expectedWeaponType = BOWS;
        //Act
        WeaponType actualWeaponType = weapon.getWeaponType();
        //Assert
        assertEquals(expectedWeaponType,actualWeaponType);
    }

    @Test
    void calculateDamageWithoutEquipment() {
        //Arrange
        ranger.setHeroAttributes(new HeroAttribute(0, 5, 0));
        //Act
        double expectedDamage = (1.0 * (1 + ranger.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = ranger.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage, 0.01);
    }

    @Test
    void calculateDamageWithValidWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        ranger.setHeroAttributes(new HeroAttribute(0, 5, 0));
        weapon.setWeaponDamage(2.0);
        ranger.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + ranger.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = ranger.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }

    @Test
    void calculateDamageWithReplacedWeaponEquipped() throws InvalidWeaponException {
        //Arrange
        ranger.setHeroAttributes(new HeroAttribute(0, 2, 0));
        weapon.setWeaponDamage(2.0);
        weapon = new Weapon("Common Bows", 1, WEAPON, BOWS); // Replacing weapon
        ranger.equip(WEAPON, weapon);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * ((1 + ranger.getHeroAttributes().getDexterity() / 100.0));
        double actualDamage = ranger.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage);
    }
    @Test
    void calculateDamageWithValidWeaponAndArmorEquipped() throws InvalidWeaponException, InvalidArmorException {
        //Arrange
        ranger.setHeroAttributes(new HeroAttribute(0, 2, 0));
        weapon.setWeaponDamage(2.0);
        ranger.equip(Slot.WEAPON, weapon);

        armor = new Armor("Common Mail", 1, Slot.BODY, MAIL);
        armor.setArmorAttribute(new HeroAttribute(0, 1, 2));
        ranger.equip(Slot.BODY, armor);
        //Act
        double expectedDamage = weapon.getWeaponDamage() * (1 + ((ranger.getHeroAttributes().getDexterity() + armor.getArmorAttribute().getDexterity()) / 100.0));
        double actualDamage = ranger.calculateDamage();
        //Assert
        assertEquals(expectedDamage, actualDamage,0.1);
    }
    @Test
    void equipValidRangerWeaponBows() throws InvalidWeaponException {
        //Arrange
        Weapon expectedWeapon = new Weapon("Bows", 1, WEAPON, WeaponType.BOWS);
        ranger.equip(WEAPON, expectedWeapon);

        //Act
        Item actualWeapon = ranger.getEquipment().get(WEAPON);

        //Assert
        assertEquals(expectedWeapon, actualWeapon);
    }

    @Test
    void equipInvalidWeapon() {

        //Arrange
        Weapon expectedWeapon = new Weapon("Sword", 1, WEAPON, WeaponType.SWORDS);
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