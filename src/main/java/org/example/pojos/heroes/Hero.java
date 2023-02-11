package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Item;

import java.util.List;
import java.util.Map;

public abstract class Hero {

    private String name;
    private int level;
    private HeroAttribute heroAttributes;
    private Map<Slot, Item> equipment;
    private List<WeaponType> validWeaponTypes;
    private List<ArmorType> validArmorTypes;


    public Hero() {
    }

    public Hero(String name) {
        level = 1;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return 1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HeroAttribute getHeroAttributes() {
        return heroAttributes;
    }

    public void setHeroAttributes(HeroAttribute heroAttributes) {
        this.heroAttributes = heroAttributes;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<Slot, Item> equipment) {
        this.equipment = equipment;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public void setValidWeaponTypes(List<WeaponType> validWeaponTypes) {
        this.validWeaponTypes = validWeaponTypes;
    }

    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }

    public void setValidArmorTypes(List<ArmorType> validArmorTypes) {
        this.validArmorTypes = validArmorTypes;
    }

//    void levelUp() {
//        level += 1;
//    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", heroAttributes=" + heroAttributes +
                ", equipment=" + equipment +
                ", validWeaponTypes=" + validWeaponTypes +
                ", validArmorTypes=" + validArmorTypes +
                '}';
    }
}
