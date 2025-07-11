package org.example.people;
import org.example.ZooModule; // Import ZooModule to access its static methods

public class AdminManager extends People {
    public AdminManager(String name) {
        super(name, "Admin/Manager");
    }

    public static void setupZooStaff() {
        System.out.println("Setting up zoo staff (functionality not yet implemented).");
    }

    public void openZoo() {
        System.out.println(getName() + " is opening the zoo.");
        ZooModule.setIsOpen(true); // Update the static status in ZooModule
    }

    public void closeZoo() {
        System.out.println(getName() + " is closing the zoo.");
        ZooModule.setIsOpen(false); // Update the static status in ZooModule
    }
}