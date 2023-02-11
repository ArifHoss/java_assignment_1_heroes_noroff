package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Item;

import java.util.List;
import java.util.Map;

public abstract class Hero {

    static int idGenerator = 1;
    private int id;
    private String name;
    private int level;
    private HeroAttribute heroAttributes;
    private Map<Slot, Item> equipment;
    private List<WeaponType> validWeaponTypes;
    private List<ArmorType> validArmorTypes;


    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name,
                int level,
                HeroAttribute heroAttributes,
                Map<Slot, Item> equipment,
                List<WeaponType> validWeaponTypes,
                List<ArmorType> validArmorTypes) {
        this.id = idGenerator++;
        this.name = name;
        this.level = level + 1;
        this.heroAttributes = heroAttributes;
        this.equipment = equipment;
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;
    }


    public abstract int levelUp();

    public abstract Map<Slot, Item> equip();

    public abstract void damage();

    public abstract HeroAttribute totalAttributes();

    public abstract String display();


    public int getId() {
        return id;
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
        return "Hero id = " + id + ", name='" + name + ", level=" + level +
                ", heroAttributes=" + heroAttributes +
                ", equipment=" + equipment +
                ", validWeaponTypes=" + validWeaponTypes +
                ", validArmorTypes=" + validArmorTypes;
    }
}
