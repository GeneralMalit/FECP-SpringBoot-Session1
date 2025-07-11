package org.example.people;

import org.example.ZooTicketing;

import java.util.Scanner;

public class Visitor extends People {
    public static Scanner scanner = new Scanner(System.in);
    private final int age;
    private String ticketCode;
    private boolean hasTicket;
    ZooTicketing ticket = new ZooTicketing();

    public Visitor(String name, int age) {
        super(name, "Visitor");
        this.age = age;
        this.hasTicket = false;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    public void buyTicket() {
        ticket.processTicketPurchasing();
    }

    public void visitorEntry() { //VISITOR ENTRY + GO TO ZOO
        System.out.println(name + " is at the zoo entry point.");
        if (hasTicket) {
            System.out.print("Please enter your ticket number: ");
            String enteredCode = scanner.nextLine();
            if (ticket.isTicketValid(enteredCode)) {
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