package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.*;
import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.*;

import java.util.*;

import static org.example.enums.ArmorType.*;
import static org.example.enums.WeaponType.*;

public class Mage extends Hero {
    private final Map<Slot, Item> equipment = new HashMap<>();

    public Mage() {
    }

    public Mage(String name) {
        super(name);
        super.setHeroAttributes(new HeroAttribute(1, 1, 8));
        List<WeaponType> validWeaponTypes = new ArrayList<>();
        validWeaponTypes.add(STAFFS);
        validWeaponTypes.add(WANDS);
        List<ArmorType> validArmorTypes = new ArrayList<>();
        validArmorTypes.add(CLOTH);
        setValidWeaponTypes(validWeaponTypes);
        setValidArmorTypes(validArmorTypes);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.getHeroAttributes().addAttributes(new HeroAttribute(1, 1, 5));


    }

    @Override
    public void equip(Slot slot, Weapon weapon) throws InvalidWeaponException {

        if (getLevel() < weapon.getRequiredLevel()) {
            throw new InvalidWeaponException("Weapon level is too high for the character");
        }
        if (!getValidWeaponTypes().contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Weapon type is not allowed for this character");
        }
        equipment.put(slot, weapon);
        setEquipment(equipment);


    }

    @Override
    public void equip(Slot slot, Armor armor) throws InvalidArmorException {

        if (getLevel() < armor.getRequiredLevel()) {
            throw new InvalidArmorException("Armor level is too high for the character");
        }
        if (!getValidArmorTypes().contains(armor.getArmorType())) {
            throw new InvalidArmorException("Armor type is not allowed for this character");
        }
        equipment.put(slot, armor);
        setEquipment(equipment);

    }

}
