package org.example.pojos.heroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(expected,actual);
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
    void equip() {
    }

    @Test
    void testEquip() {
    }
}