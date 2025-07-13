package org.example;

import org.example.animals.*;
import org.example.buildings.*;
import org.example.people.Handler;
import org.example.people.Veterinarian;


import java.util.*;

public class ZooModule {
    private Scanner scanner;
    boolean isOpen = true;

    public void setZoo(boolean open) {
        this.isOpen = open;
    }

    public ZooModule(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void runZooModule() {
        scanner = new Scanner(System.in);

        if(!isOpen){
            System.out.println("\nThe zoo is closed, please come back later.\n");
            return;
        }
        System.out.println("Entering Zoo Ticketing Module...");
        int choice;

        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Leave Zoo");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Visit Enclosure
                    zooEnclosure();
                }

                case 2 -> {
                    Shop shop = new Shop();
                    shop.zooShop();
                    // Visit Shop
                }

                case 3 -> {
                    // Visit Hospital
                    zooHospital();
                }

                default -> {
                    // exit
                    System.out.println("Invalid option. Please choose a number from 1-4.");
                }
            }
        } while (choice != 4);
        System.out.println("You have left the zoo. 👋");
    }


    public void zooEnclosure() {
        scanner = new Scanner(System.in);
        int choice;
        String animalType;
        String species;
        String feedAnimal;

        do {
            System.out.println("\n=== Zoo Enclosure ===");
            System.out.println("Choose Enclosure");
            System.out.println("1. Pachyderm");
            System.out.println("2. Feline");
            System.out.println("3. Bird");
            System.out.println("4. Go Back");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    // go to pachyderm enclosure
                    System.out.println("Choose animal type (Rhino, Elephant, Hippo): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Rhino") &&
                            !animalType.equalsIgnoreCase("Elephant") &&
                            !animalType.equalsIgnoreCase("Hippo")) {
                        System.out.println("Invalid animal!");
                        return;
                    }
                    species = "Pachyderm";
                    PachydermEnclosure pachydermEnclosure = new PachydermEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + pachydermEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                case 2 -> {
                    // go to feline enclosure
                    System.out.println("Choose animal type (Tiger, Lion, Cheetah): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Tiger") &&
                            !animalType.equalsIgnoreCase("Lion") &&
                            !animalType.equalsIgnoreCase("Cheetah")) {
                        System.out.println("Invalid animal!");
                        return;
                    }
                    species = "Feline";
                    FelineEnclosure felineEnclosure = new FelineEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + felineEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                case 3 -> {
                    // go to bird enclosure
                    System.out.println("Choose animal type (Parrot, Falcon, Owl): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Parrot") &&
                            !animalType.equalsIgnoreCase("Falcon") &&
                            !animalType.equalsIgnoreCase("Owl")) {
                        System.out.println("Invalid animal!");
                        return; // Exit the current method if invalid animal is chosen
                    }
                    species = "Bird";
                    BirdEnclosure birdEnclosure = new BirdEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + birdEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                default -> {
                    System.out.println("Invalid option. Please choose a number from 1-4.");
                }
            }

        } while (choice != 4);
    }

    private void getAnimalActions(String animalType) {
        String className = "org.example.animals." + animalType;
        try{
            Animal animal = (Animal) Class.forName(className).getDeclaredConstructor().newInstance();
            animal.setName(animalType);
            animal.eat();
            animal.makeSound();
        }catch (Exception e){
            System.out.println("Animal type does not exist");
            e.printStackTrace();
        }
    }

    private void zooHospital() {
        Hospital hospital = new Hospital();
        Veterinarian vet = new Veterinarian("Dr. Ellie");
        scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("=== Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian)");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    hospital.viewSickAnimals(Handler.sickAnimals);
                }

                case 2 -> {
                    vet.viewHealedAnimals();
                }

                case 3 -> {
                    hospital.attendScienceLecture(vet);
                }

                case 4 -> {
                    System.out.println("Are you a Vet? (yes/no)");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        vet.healAnimals(Handler.sickAnimals, vet);
                    }else{
                        System.out.println("Only vet can heal animals!");
                    }
                }
                default -> {
                    System.out.println("Invalid option. Please choose a number from 1-5.");
                }
            }
        } while (choice !=5);
    }


}
