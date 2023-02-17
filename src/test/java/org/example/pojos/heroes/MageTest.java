package org.example.pojos.heroes;

import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void testLevelUp() {
    }

    @Test
    void equipValidWeapon() throws InvalidWeaponException {
        Weapon staff = new Weapon("Staff fo Testing", 1, WEAPON, WeaponType.STAFFS, 10);
        mage.equip(WEAPON, staff);
        assertEquals(staff, mage.getEquipment().get(WEAPON));
    }

    @Test
    void equipInvalidWeapon() throws InvalidWeaponException {
        Weapon sword = new Weapon("Sword fo Testing", 1, WEAPON, WeaponType.SWORDS, 10);
        mage.equip(Slot.WEAPON, sword);
        assertNull(mage.getEquipment().get(Slot.WEAPON));

    }
}