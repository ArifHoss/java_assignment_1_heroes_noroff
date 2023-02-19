# RPG Heroes

## Introduction:
This is a Java console application that allows players to create and customize heroes with different classes and equipment. 
The application includes custom exceptions to handle errors and invalid inputs, and it has been thoroughly tested to ensure that 
it is functioning correctly.

## Requirements:
To run the RPG Heroes application, you will need:
IntelliJ Ultimate with JDK 17.

## Features:
1. The RPG Heroes application has the following features
2. Four hero classes with different attributes that increase at different rates as the character gains levels:
  Mage, Ranger, Rogue, and Warrior.
3. Equipment such as armor and weapons that characters can equip to alter the power of the hero, 
   causing it to deal more damage and survive longer.Certain heroes can equip certain item types.
4. Custom exceptions for handling errors and invalid inputs: InvalidWeaponException and InvalidArmorException.

## Installation:
Clone the project from GitHub or download the ZIP file.
Open the project in IntelliJ Ultimate.
Build and run the application from the IDE.

## Unit Testing:
The RPG Heroes application has been thoroughly tested using JUnit5 to ensure that it is functioning correctly. The tests cover all the main features of the application, including hero creation, leveling up, equipping items, and displaying hero status.

The following tests have been performed:

* Creation and leveling tests for each subclass
* Testing for weapon and armor creation, equipping, and exceptions
* Testing for total attributes and damage calculations
* Testing for displaying hero state
* The tests were designed to achieve maximum coverage and have followed best practices for test development. 
* The tests have been performed on four different heroes and have resulted in a high level of coverage.

## Custom Exceptions:
The application has two custom exceptions for handling errors and invalid inputs:

* InvalidWeaponException - This exception is thrown when a hero tries to equip an weapon that it cannot use.
* InvalidArmorException - This exception is thrown when a hero is created with an invalid armor.

## Conclusion:
The RPG Heroes application is a console-based game that allows players to create and customize heroes with 
different classes and equipment. The application includes custom exceptions to handle errors and invalid inputs, 
and it has been thoroughly tested to ensure that it is functioning correctly.
