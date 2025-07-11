package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ZooTicketing {
    private final Scanner scanner = new Scanner(System.in);
    private Set<Integer> generatedTicketNumbers = new HashSet<>();

    public void processTicketPurchasing(){
        printPricingAndActivities();
        System.out.print("Would you like to buy a ticket? (yes/no): ");
        String purchase = scanner.nextLine();
        if(purchase.equalsIgnoreCase("no")){
            return;
        }
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age:");
        int age = Integer.parseInt(scanner.nextLine());
        if(age < 0){
            System.out.println("Invalid age!");
            return;
        }
        String[] ageClass = checkAgeClassification(age);
        String ticketType = ageClass[0].toUpperCase();
        Double ticketPrice = Double.parseDouble(ageClass[1]);

        System.out.println("You qualify for a " + ticketType + "ticket");
        System.out.printf("Ticket Price: ₱%.2f%n", ticketPrice);

        System.out.println("Proceed with purchase? (yes/no)");
        String proceedToBuy = scanner.nextLine();

    }

    public void printPricingAndActivities(){
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("Buy snacks and drinks from shops");
        System.out.println("Listen to science lectures at the Hospital");
        System.out.println("Buy fun gifts at our Gift Shop");

        System.out.printf("%-20s %-10s %-10s%n", "Age Range", "Ticket Type", "Price (₱)");
        System.out.printf("%-20s %-10s %-10s%n", "0 – 5 years", "Child", "₱0.00");
        System.out.printf("%-20s %-10s %-10s%n", "6 – 17 years", "Student", "₱75.00");
        System.out.printf("%-20s %-10s %-10s%n", "18 – 59 years", "Adult", "₱150.00");
        System.out.printf("%-20s %-10s %-10s%n", "60 years and above", "Senior", "₱50.00");
    }

    public String[] checkAgeClassification(int age){
        if(age <= 5){
            return new String[]{"Child", "0"};
        } else if (age <= 17) {
            return new String[]{"Student", "75"};
        } else if (age <= 59) {
            return new String[]{"Adult", "150"};
        } else
            return new String[]{"Senior", "50"};
    }

    public Set<Integer> getGeneratedTicketNumbers() {
        return generatedTicketNumbers;
    }

    public void setGeneratedTicketNumbers(Set<Integer> generatedTicketNumbers) {
        this.generatedTicketNumbers = generatedTicketNumbers;
    }

}
