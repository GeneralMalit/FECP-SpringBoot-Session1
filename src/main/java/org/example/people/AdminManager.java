package org.example.people;

public class AdminManager extends People {
    public AdminManager(String name) {
        super(name, "Admin/Manager");
    }

    public void openZoo() {
        System.out.println(name + " (Admin/Manager) is opening the Zoo for visitors.");
        // Placeholder for actual logic for opening the zoo
    }

    public void closeZoo() {
        System.out.println(name + " (Admin/Manager) is closing the Zoo to visitors.");
        // Placeholder for actual logic for closing the zoo
    }

    public void setupZooStaff() {
        System.out.println("\n--- Setting up Zoo Staff ---");
        System.out.println("Haven't implemented it yet.");
        //creating/updating staff objects in a database or collection.
    }
}