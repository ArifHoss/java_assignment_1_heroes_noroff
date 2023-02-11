package org.example;

import org.example.enums.ArmorType;
import org.example.pojos.heroes.HeroAttribute;
import org.example.pojos.heroes.Mage;
import org.example.services.MageManagementServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        MageManagementServiceImpl hero = new MageManagementServiceImpl();

        hero.createHero();
    }
}