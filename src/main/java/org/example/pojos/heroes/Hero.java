package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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



    public void levelUp() {
        this.level++;
    }

    public abstract void equip(Slot slot,Weapon weapon) throws InvalidWeaponException;
    public abstract void equip(Slot slot,Armor armor) throws InvalidWeaponException, InvalidArmorException;

    public double damage(){
            double weaponDamage = 1.0;
            if (getEquipment().containsKey(Slot.WEAPON)) {
                Item item = getEquipment().get(Slot.WEAPON);
                if (item instanceof Weapon) {
                    weaponDamage = ((Weapon) item).getWeaponDamage();
                }
            }

            int damagingAttribute = 0;
            if (this instanceof Warrior) {
                damagingAttribute = getHeroAttributes().getStrength();
            } else if (this instanceof Mage) {
                damagingAttribute = getHeroAttributes().getIntelligence();
            } else if (this instanceof Ranger || this instanceof Rogue) {
                damagingAttribute = getHeroAttributes().getDexterity();
            }

            double totalDamage = weaponDamage * (1 + damagingAttribute / 100.0);
//            System.out.println("Total Damage: " + totalDamage);
        return totalDamage;
    }

    public void totalAttributes(){

        HeroAttribute totalAttributes = new HeroAttribute(getHeroAttributes().getStrength(), getHeroAttributes().getDexterity(), getHeroAttributes().getIntelligence());

        for (Item item : equipment.values()) {
            if (item instanceof Armor) {
                totalAttributes.addAttributes(((Armor) item).getArmorAttribute());
            }
        }

        System.out.println("Total Attributes: " + totalAttributes);
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + getName() + "\t");
        sb.append("Class: " + getClass() + "\t");
        sb.append("Level: " + getLevel() + "\t");
        sb.append("Total Strength: " + getHeroAttributes().getStrength() + "\t");
        sb.append("Total Dexterity: " + getHeroAttributes().getDexterity() + "\t");
        sb.append("Total Intelligence: " + getHeroAttributes().getIntelligence() + "\t");
        sb.append("Equipment: " + getEquipment() + "\t");
        return sb.toString();
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return getLevel() == hero.getLevel() && Objects.equals(getName(), hero.getName()) && Objects.equals(getHeroClass(), hero.getHeroClass()) && getHeroAttributes().equals(hero.getHeroAttributes()) && Objects.equals(getEquipment(), hero.getEquipment()) && Objects.equals(getValidWeaponTypes(), hero.getValidWeaponTypes()) && Objects.equals(getValidArmorTypes(), hero.getValidArmorTypes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeroClass(), getLevel(), getHeroAttributes(), getEquipment(), getValidWeaponTypes(), getValidArmorTypes());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + "\t");
        sb.append("Class: " + heroClass + "\t");
        sb.append("Level: " + level + "\t");
        sb.append("Total Strength: " + heroAttributes.getStrength() + "\t");
        sb.append("Total Dexterity: " + heroAttributes.getDexterity() + "\t");
        sb.append("Total Intelligence: " + heroAttributes.getIntelligence() + "\t");
        sb.append("Equipment: " + equipment + "\t");
        return sb.toString();
    }
}
