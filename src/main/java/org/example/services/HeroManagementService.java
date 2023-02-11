package org.example.services;

import org.example.enums.ArmorType;
import org.example.pojos.heroes.HeroAttribute;
import org.example.pojos.heroes.Mage;

import java.util.List;

public class HeroManagementService {

    public void createHero() {
        Mage mage = new Mage("Erik");
        mage.setHeroAttributes(new HeroAttribute(1,1,8));
        mage.setValidArmorTypes(List.of(ArmorType.CLOTH));
        mage.setLevel(2);

        System.out.println(mage);
    }



}
