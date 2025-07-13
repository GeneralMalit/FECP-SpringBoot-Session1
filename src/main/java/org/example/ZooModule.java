package org.example;

import org.example.animals.Animal;
import org.example.animals.Pachyderm;
import org.example.buildings.BirdEnclosure;
import org.example.buildings.FelineEnclosure;
import org.example.buildings.PachydermEnclosure;
import org.example.buildings.Shop;

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
            System.out.println("The zoo is still not open, please come back later.\n");
            return;
        }

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
                    species = "Pachyderm";
                    PachydermEnclosure pachydermEnclosure = new PachydermEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + pachydermEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        System.out.println(animalType + " is eating.");
                    }
                    getAnimalActions(animalType);
                }

                case 2 -> {
                    // go to feline enclosure
                    System.out.println("Choose animal type (Tiger, Lion, Cheetah): ");
                    animalType = scanner.nextLine();
                    species = "Feline";
                    FelineEnclosure felineEnclosure = new FelineEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + felineEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        System.out.println("\n" + animalType + " is eating.");
                    }
                    getAnimalActions(animalType);
                }

                case 3 -> { //FIX HERE -g
                    // go to bird enclosure
                    System.out.println("Choose animal type (Parrot, Falcon, Owl): ");
                    animalType = scanner.nextLine();
                    species = "Bird";
                    BirdEnclosure birdEnclosure = new BirdEnclosure(species, animalType);
                    System.out.println("Would you like to feed " + birdEnclosure.getAnimalType() + "? (yes/no)");
                    feedAnimal = scanner.nextLine();
                    if(feedAnimal.equalsIgnoreCase("yes")){
                        System.out.println(animalType + " is eating.");
                    }
                    getAnimalActions(animalType);
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
            animal.makeSound();
        }catch (Exception e){
            System.out.println("Animal type does not exist");
            e.printStackTrace();
        }
    }

    private void zooHospital() {
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

            switch (choice) {
                case 1 -> {
                    // view sick animals
                }

                case 2 -> {
                    // view healed animals
                }

                case 3 -> {
                    // attend science lecture
                }

                case 4 -> {
                    // heal animals
                    // check role
                }
                default -> {
                    System.out.println("Invalid option. Please choose a number from 1-5.");
                }
            }
        } while (choice !=5);
    }


}
