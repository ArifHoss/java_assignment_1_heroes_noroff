package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.*;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.*;

import java.util.*;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
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
    public void equip(Weapon weapon) {

        if (getLevel() >= weapon.getRequiredLevel() && getValidWeaponTypes().contains(weapon.getWeaponType())) {
            equipment.put(WEAPON, weapon);
            setEquipment(equipment);
        }

    }

    @Override
    public void equip(Armor armor) {
        if (getLevel() >= armor.getRequiredLevel() && getValidArmorTypes().contains(armor.getArmorType())) {
            equipment.put(WEAPON, armor);
            setEquipment(equipment);
        }
    }

}
