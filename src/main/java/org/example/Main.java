package org.example;

import org.example.services.HeroManagementService;

public class Main {
    public static void main(String[] args) {
        
        HeroManagementService hero = new HeroManagementService();

        hero.createHero();
    }
}