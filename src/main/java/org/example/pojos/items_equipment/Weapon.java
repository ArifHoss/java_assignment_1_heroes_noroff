package org.example.pojos.items_equipment;

import org.example.enums.WeaponType;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int weaponDamage;

    public Weapon() {
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
}
