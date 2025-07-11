package org.example.people;

import java.util.Scanner;



public class Visitor extends People {
    public static Scanner scanner = new Scanner(System.in);
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

    public void goToTicketShop() {
        //
    }

    public void visitorEntry() { //VISITOR ENTRY + GO TO ZOO
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