package org.example;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import static org.example.Main.zoo;

public class ZooTicketing {
    private final Scanner scanner = new Scanner(System.in);
    private static Set<String> generatedTicketCodes = new HashSet<>();

    public void processTicketPurchasing(){
        if(!zoo.isOpen){
            System.out.println("\n--- Zoo Status ---");
            System.out.println("The zoo is currently closed. Please check back later.");
            System.out.println(); // Add a newline for spacing
            return;
        }

        System.out.println("\n--- Welcome to Zoo Ticketing ---");
        printPricingAndActivities();

        System.out.print("Would you like to purchase a ticket? (yes/no): ");
        String purchaseChoice = scanner.nextLine();

        if (!purchaseChoice.equalsIgnoreCase("yes")) {
            System.out.println("Ticket purchase cancelled. Returning to main menu.");
            System.out.println(); // Add a newline for spacing
            return;
        }

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Please enter your age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 0) {
                    System.out.println("Invalid age. Age cannot be negative. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical value for age.");
            }
        }

        String[] ageClass = checkAgeClassification(age);
        String ticketType = ageClass[0].toUpperCase();
        double ticketPrice = Double.parseDouble(ageClass[1]);

        System.out.println("\n--- Ticket Confirmation ---");
        System.out.println("Hello, " + name.toUpperCase() + "!");
        System.out.println("You qualify for a " + ticketType + " ticket.");
        System.out.printf("Ticket Price: ₱%.2f%n", ticketPrice);

        System.out.print("Proceed with payment? (yes/no): ");
        String proceedToBuy = scanner.nextLine();

        if (!proceedToBuy.equalsIgnoreCase("yes")) {
            System.out.println("Ticket purchase cancelled. Returning to main menu.");
            System.out.println(); // Add a newline for spacing
            return;
        }

        String ticketCode = "ZOO-" + generateTicketCode();
        generatedTicketCodes.add(ticketCode);

        System.out.println("\n--- Purchase Complete ---");
        System.out.println("Your ticket code is: " + ticketCode);
        System.out.println("Thank you for your purchase!");
        System.out.println(); // Add a newline for spacing
    }

    private int generateTicketCode() {
        Random random = new Random();
        int code;
        // Ensure generated code is unique, though with 10000 options, collisions are rare initially
        do {
            code = 1000 + random.nextInt(9000); // Generates a 4-digit number (1000-9999)
        } while (generatedTicketCodes.contains("ZOO-" + code));
        return code;
    }

    public void printPricingAndActivities(){
        System.out.println("\n--- Zoo Activities and Pricing ---");
        System.out.println("Here's what you can experience at the zoo:");
        System.out.println("- Visit a variety of Animal Enclosures (e.g., Elephants, Lions, Owls)");
        System.out.println("- Enjoy snacks and beverages from our food stalls");
        System.out.println("- Attend insightful science lectures at the Hospital Auditorium");
        System.out.println("- Discover unique souvenirs at our Gift Shop");

        System.out.println("\n--- Ticket Pricing ---");
        System.out.printf("%-20s %-15s %-10s%n", "Age Range", "Ticket Type", "Price");
        System.out.printf("%-20s %-15s %-10s%n", "0 – 5 years", "Child", "FREE");
        System.out.printf("%-20s %-15s %-10s%n", "6 – 17 years", "Student", "₱75.00");
        System.out.printf("%-20s %-15s %-10s%n", "18 – 59 years", "Adult", "₱150.00");
        System.out.printf("%-20s %-15s %-10s%n", "60 years and above", "Senior", "₱50.00");
        System.out.println(); // Add a newline for spacing
    }

    public String[] checkAgeClassification(int age){
        // Check age for ticket classification and pricing
        if(age <= 5){
            return new String[]{"Child", "0"};
        } else if (age <= 17) {
            return new String[]{"Student", "75"};
        } else if (age <= 59) {
            return new String[]{"Adult", "150"};
        } else { // age >= 60
            return new String[]{"Senior", "50"};
        }
    }

    public static boolean isTicketValid(String ticketCode){
        return generatedTicketCodes.contains(ticketCode);
    }

    public Set<String> getGeneratedTicketCodes() {
        return generatedTicketCodes;
    }

    public void setGeneratedTicketCodes(Set<String> generatedTicketCodes) {
        ZooTicketing.generatedTicketCodes = generatedTicketCodes;
    }
}