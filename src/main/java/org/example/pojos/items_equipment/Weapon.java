package org.example.pojos.items_equipment;

import org.example.enums.Slot;
import org.example.enums.WeaponType;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int weaponDamage;

    public Weapon() {
    }

    public Weapon(WeaponType weaponType, int weaponDamage) {
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, int weaponDamage) {
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

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    @Override
    public String toString() {
        return " WeaponType = " + weaponType +"\t"+
                ", weaponDamage = " + weaponDamage+"\t";
    }
}
