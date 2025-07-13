package org.example.people;
import org.example.ZooModule;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.Main.zoo;

public class AdminManager extends People {

    // Static map to store staff roles and their names
    private static final Map<String, String> zooStaff = new LinkedHashMap<>();

    public AdminManager(String name) {
        super(name, "Admin/Manager");
        // Initialize the manager's name in the staff map if not already set
        if (!zooStaff.containsKey("Manager")) {
            zooStaff.put("Manager", name);
        }
    }

    public static void setupZooStaff(Scanner scanner) { // Accept Scanner as parameter
        System.out.println("\n--- Setup Zoo Staff ---");

        if (!zooStaff.isEmpty()) {
            System.out.println("Current Zoo Staff configuration:");
            displayZooStaff();
            System.out.print("Would you like to update the existing staff? (yes/no): ");
            String updateChoice = scanner.nextLine().trim().toLowerCase();
            if (!updateChoice.equals("yes")) {
                System.out.println("Staff setup/update cancelled.");
                return;
            }
        } else {
            System.out.print("Would you like to set up zoo staff? (yes/no): ");
            String setupChoice = scanner.nextLine().trim().toLowerCase();
            if (!setupChoice.equals("yes")) {
                System.out.println("Staff setup cancelled.");
                return;
            }
        }

        System.out.println("\nPlease enter names for the following roles:");

        // Define the roles to be set up.  Manager is predefined but should be updated.
        String[] rolesToSetup = {"Manager", "Ticket Vendor", "Shop Vendor", "Veterinarian", "Handler"};

        for (String role : rolesToSetup) {
            System.out.print("Enter name for " + role + ": ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                zooStaff.put(role, name);
            } else {
                System.out.println("Name cannot be empty for " + role + ". Skipping this role / keeping previous");
            }
        }

        System.out.println("\nZoo Staff setup complete.");
        displayZooStaff();
    }

    // Helper method to display current staff
    private static void displayZooStaff() {
        if (zooStaff.isEmpty()) {
            System.out.println("No staff members have been set up yet.");
            return;
        }
        System.out.println("--- Current Zoo Staff ---");
        for (Map.Entry<String, String> entry : zooStaff.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("-------------------------");
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

    public static String getStaffName(String role) {
        return zooStaff.get(role);
    }

}