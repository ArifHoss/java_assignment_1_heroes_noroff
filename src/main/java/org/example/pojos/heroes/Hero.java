package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Item;

import java.util.List;
import java.util.Map;

public abstract class Hero {
    private String name;
    private String heroClass;
    private int level = 1;
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
                String heroClass,
                int level,
                HeroAttribute heroAttributes,
                Map<Slot, Item> equipment,
                List<WeaponType> validWeaponTypes,
                List<ArmorType> validArmorTypes) {
        this.name = name;
        this.heroClass = heroClass;
        this.level += level;
        this.heroAttributes = heroAttributes;
        this.equipment = equipment;
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;
    }


    public abstract int levelUp(int level);

    public abstract Map<Slot, Item> equip();

    public abstract void damage();

    public abstract void totalAttributes();

    public abstract String display();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Name: "+ name+"\t");
        sb.append("Class: "+heroClass+"\t");
        sb.append("Level: "+level+"\t");
        sb.append("Total Strength: "+heroAttributes.getStrength()+"\t");
        sb.append("Total Dexterity: "+heroAttributes.getDexterity()+"\t");
        sb.append("Total Intelligence: "+heroAttributes.getIntelligence()+"\t");
        sb.append("Equipment: " + equipment +"\t");
        return sb.toString();
    }
}
