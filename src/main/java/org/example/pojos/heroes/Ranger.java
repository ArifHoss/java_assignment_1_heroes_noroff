package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.enums.ArmorType.LEATHER;
import static org.example.enums.ArmorType.MAIL;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.BOWS;

public class Ranger extends Hero {

    private final Map<Slot, Item> equipment = new HashMap<>();

    public Ranger() {
    }

    public Ranger(String name) {
        super(name);
        setHeroAttributes(new HeroAttribute(1, 7, 1));
        List<WeaponType> validWeaponTypes = new ArrayList<>();
        validWeaponTypes.add(BOWS);
        List<ArmorType> validArmorTypes = new ArrayList<>();
        validArmorTypes.add(LEATHER);
        validArmorTypes.add(MAIL);
        setValidWeaponTypes(validWeaponTypes);
        setValidArmorTypes(validArmorTypes);


    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.getHeroAttributes().addAttributes(new HeroAttribute(1,5,1));
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
