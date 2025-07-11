package org.example.people;

import java.util.Scanner;


public class Visitor extends People {
    private final int age;
    private double ticketPrice;
    private String ticketCode;
    private boolean hasTicket;

    public Visitor(String name, int age) {
        super(name, "Visitor");
        this.age = age;
        this.hasTicket = false;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    public void goToTicketShop(Scanner scanner) {
        System.out.println(name + " (Visitor) is at the Ticket Shop.");
        System.out.print("Do you want to buy a ticket? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            buyTicket(scanner);
        } else {
            System.out.println("Visitor chose not to buy a ticket.");
        }
    }


    private void buyTicket(Scanner scanner) {
        System.out.println(name + " is proceeding to buy a ticket.");
        computeTicketPrice();
        System.out.println("Your ticket price is: $" + String.format("%.2f", ticketPrice));

        if (proceedWithPurchase(scanner)) {

            //RANDOM TICKET CODE GENERATOR, remove if there is another way to make it unique.
            this.ticketCode = "TICKET" + (int)(Math.random() * 9000) + 1000;
            this.hasTicket = true;
            System.out.println("Ticket purchased successfully! Your ticket code is: " + ticketCode);
        } else {
            System.out.println("Ticket purchase cancelled.");
        }
    }

    private void computeTicketPrice() {
        if (age < 5) {
            ticketPrice = 0.00; // Free for kids under 5
        } else if (age < 18) {
            ticketPrice = 75.00; // Child price
        } else if (age < 60) {
            ticketPrice = 150.00; // Adult price
        } else {
            ticketPrice = 150.00; // Senior price
        }
    }


    private boolean proceedWithPurchase(Scanner scanner) {
        System.out.print("Proceed with purchase? (yes/no): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }


    public void visitorEntry(Scanner scanner) { //VISITOR ENTRY + GO TO ZOO
        System.out.println(name + " is at the zoo entry point.");
        if (hasTicket) {
            System.out.print("Please enter your ticket number: ");
            String enteredCode = scanner.nextLine();
            if (enteredCode.equals(this.ticketCode)) {
                System.out.println("Ticket validated. Welcome to the Zoo, " + name + "!");
                goToZoo();
            } else {
                System.out.println("Invalid ticket code. Access denied.");
            }
        } else {
            System.out.println("You don't have a ticket. Please buy one first.");
        }
    }

    public void goToZoo() {
        System.out.println(name + " is now exploring the Zoo Module.");
        System.out.println("Please complete this implementation.");
    }
}