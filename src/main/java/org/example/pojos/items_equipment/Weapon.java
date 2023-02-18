package org.example.pojos.items_equipment;

import org.example.enums.Slot;
import org.example.enums.WeaponType;

public class Weapon extends Item {
    private WeaponType weaponType;
    private double weaponDamage;

    public Weapon() {
    }

    public Weapon(String name) {
        super(name);
    }

    public Weapon(int requiredLevel, Slot slot) {
        super(requiredLevel, slot);
    }

    public Weapon(WeaponType weaponType, double weaponDamage) {
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }






    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, double weaponDamage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    @Override
    public String toString() {
        return " WeaponType = " + weaponType +"\t"+
                ", weaponDamage = " + weaponDamage+"\t";
    }
}
