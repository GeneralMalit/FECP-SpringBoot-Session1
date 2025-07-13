package org.example.people;
import org.example.Main;

import static org.example.Main.zoo;

public class AdminManager extends People {
    public AdminManager(String name) {
        super(name, "Admin/Manager");
    }

    public static void setupZooStaff() {
        System.out.println("Setting up zoo staff (functionality not yet implemented).");
    }

    // These methods are instance methods in ZooAdminModule: manager.openZoo(); manager.closeZoo();
    public void openZoo() {
        System.out.println(getName() + " is opening the zoo.");
        zoo.setZoo(true); // Update the static status in Main
    }

    public void closeZoo() {
        System.out.println(getName() + " is closing the zoo.");
        zoo.setZoo(false); // Update the static status in Main
    }
}