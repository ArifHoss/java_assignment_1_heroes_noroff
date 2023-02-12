package org.example.services;

import org.example.pojos.heroes.*;

import static org.example.services.HeroManagementService.*;

public class Main {
    public static void main(String[] args) {


        createMage();
        createRanger();
        createRogue();
        createWarrior();
        display();

    }

}