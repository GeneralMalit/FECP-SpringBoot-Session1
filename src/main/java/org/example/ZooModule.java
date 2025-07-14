package org.example;

import org.example.animals.*;
import org.example.buildings.*;
import org.example.people.AdminManager;
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
        scanner = new Scanner(System.in); // Initialize scanner here

        if(!isOpen){
            System.out.println("\n--- Zoo Status ---"); // Consistent header
            System.out.println("The zoo is currently closed. Please come back later.");
            System.out.println(); // Add a newline for spacing
            return;
        }

        System.out.println("\n--- Welcome to the Zoo ---"); // Consistent header
        int choice;

        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Leave Zoo");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Set to an invalid choice to repeat loop
                continue;
            }

            switch (choice) {
                case 1 -> zooEnclosure();
                case 2 -> {
                    Shop shop = new Shop();
                    shop.zooShop();
                }
                case 3 -> zooHospital();
                case 4 -> System.out.println("Exiting the Zoo. Goodbye!"); // Professional exit message
                default -> System.out.println("Invalid option. Please choose a number from 1 to 4.");
            }
            System.out.println(); // Add a newline for spacing after each interaction
        } while (choice != 4);
    }


    public void zooEnclosure() {
        // scanner = new Scanner(System.in); // Scanner already initialized in runZooModule
        int choice;
        String animalType;
        String species;
        String feedAnimal;

        do {
            System.out.println("\n--- Zoo Enclosure ---"); // Consistent header
            System.out.println("Choose an Enclosure:");
            System.out.println("1. Pachyderm Enclosure");
            System.out.println("2. Feline Enclosure");
            System.out.println("3. Bird Enclosure");
            System.out.println("4. Go Back");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Set to an invalid choice to repeat loop
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter animal type (Rhino, Elephant, Hippo): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Rhino") &&
                            !animalType.equalsIgnoreCase("Elephant") &&
                            !animalType.equalsIgnoreCase("Hippo")) {
                        System.out.println("Invalid animal type selected.");
                        continue; // Go back to enclosure menu
                    }
                    species = "Pachyderm";
                    PachydermEnclosure pachydermEnclosure = new PachydermEnclosure(species, animalType);
                    System.out.print("Would you like to feed " + pachydermEnclosure.getAnimalType() + "? (yes/no): ");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                case 2 -> {
                    System.out.print("Enter animal type (Tiger, Lion, Cheetah): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Tiger") &&
                            !animalType.equalsIgnoreCase("Lion") &&
                            !animalType.equalsIgnoreCase("Cheetah")) {
                        System.out.println("Invalid animal type selected.");
                        continue; // Go back to enclosure menu
                    }
                    species = "Feline";
                    FelineEnclosure felineEnclosure = new FelineEnclosure(species, animalType);
                    System.out.print("Would you like to feed " + felineEnclosure.getAnimalType() + "? (yes/no): ");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                case 3 -> {
                    System.out.print("Enter animal type (Parrot, Falcon, Owl): ");
                    animalType = scanner.nextLine();
                    if (!animalType.equalsIgnoreCase("Parrot") &&
                            !animalType.equalsIgnoreCase("Falcon") &&
                            !animalType.equalsIgnoreCase("Owl")) {
                        System.out.println("Invalid animal type selected.");
                        continue; // Go back to enclosure menu
                    }
                    species = "Bird";
                    BirdEnclosure birdEnclosure = new BirdEnclosure(species, animalType);
                    System.out.print("Would you like to feed " + birdEnclosure.getAnimalType() + "? (yes/no): ");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        getAnimalActions(animalType);
                    }

                }

                case 4 -> System.out.println("Returning to main Zoo menu.");
                default -> System.out.println("Invalid option. Please choose a number from 1 to 4.");
            }
            System.out.println(); // Add a newline for spacing after each interaction
        } while (choice != 4);
    }

    private void getAnimalActions(String animalType) {
        // Convert string to First letter uppercase format
        animalType = animalType.toLowerCase();
        animalType = animalType.substring(0, 1).toUpperCase() + animalType.substring(1);
        String className = "org.example.animals." + animalType;
        try{
            Animal animal = (Animal) Class.forName(className).getDeclaredConstructor().newInstance();
            animal.setName(Main.ANIMAL_NAMES.get(animalType));
            animal.eat();
            animal.makeSound();
        }catch (Exception e){
            System.out.println("Error: Animal type not found or cannot be instantiated.");
            // e.printStackTrace(); // Removed stack trace for cleaner output
        }
    }

    private void zooHospital() {
        Hospital hospital = new Hospital();
        String vetName = AdminManager.getStaffName("Veterinarian");
        Veterinarian vet = new Veterinarian(vetName);

        // scanner = new Scanner(System.in); // Scanner already initialized

        int choice;

        do {
            System.out.println("\n--- Zoo Hospital ---"); // Consistent header
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian Access Only)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Set to an invalid choice to repeat loop
                continue;
            }

            switch (choice) {
                case 1 -> hospital.viewSickAnimals(Handler.sickAnimals);
                case 2 -> vet.viewHealedAnimals();
                case 3 -> hospital.attendScienceLecture(vet);
                case 4 -> {
                    System.out.print("Are you a Veterinarian? (yes/no): ");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        vet.healAnimals(Handler.sickAnimals, vet);
                    }else{
                        System.out.println("Access denied: Only veterinarians can heal animals.");
                    }
                }
                case 5 -> System.out.println("Returning to main Zoo menu.");
                default -> System.out.println("Invalid option. Please choose a number from 1 to 5.");
            }
            System.out.println(); // Add a newline for spacing after each interaction
        } while (choice !=5);
    }
}