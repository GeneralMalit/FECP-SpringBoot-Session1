package org.example;
import org.example.people.AdminManager;
import org.example.people.Handler;
import org.example.people.People;

import java.util.*;

public class ZooAdminModule {

    // Hardcoded credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminpass";
    private static final String HANDLER_USERNAME = "handler";
    private static final String HANDLER_PASSWORD = "handlerpass";

    private static final Scanner scanner = new Scanner(System.in);
    private static People loggedInUser = null; // Stores the currently logged-in user object

    public ZooAdminModule() {
    }


    /**
     * Main entry point for the Zoo Admin Module.
     */
    public static void main(String[] args) {
        runAdminModule();
    }

    public static void runAdminModule() {
        System.out.println("\n--- Admin Module ---"); // Consistent header
        boolean loggedIn = login();

        if (loggedIn) {
            if (loggedInUser instanceof AdminManager) {
                displayManagerMenu((AdminManager) loggedInUser);
            } else if (loggedInUser instanceof Handler) {
                displayHandlerMenu((Handler) loggedInUser);
            }
        } else {
            System.out.println("Login failed. Exiting Admin Module.");
        }
    }


    private static boolean login() {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                loggedInUser = new AdminManager("AdminUser"); // generic admin
                System.out.println("Login successful for Admin.");
                return true;
            } else if (username.equals(HANDLER_USERNAME) && password.equals(HANDLER_PASSWORD)) {
                loggedInUser = new Handler("HandlerUser"); // generic handler
                System.out.println("Login successful for Handler.");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
                attempts++;
            }
        }
        System.out.println("Too many failed login attempts. Exiting module.");
        return false;
    }


    private static void displayManagerMenu(AdminManager manager) {
        int choice;
        do {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Open Zoo");
            System.out.println("3. Close Zoo");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1; // Set to an invalid choice to repeat loop
                continue;
            }

            switch (choice) {
                case 1:
                    AdminManager.setupZooStaff(scanner);
                    break;
                case 2:
                    manager.openZoo();
                    break;
                case 3:
                    manager.closeZoo();
                    break;
                case 4:
                    System.out.println("Exiting Manager Menu. Goodbye, " + manager.getName() + ".");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add a newline for spacing after each interaction
        } while (choice != 4);
    }


    private static void displayHandlerMenu(Handler handler) {
        int choice;
        do {
            System.out.println("\n--- Handler Menu ---");
            System.out.println("1. Access Handler Module");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1; // Set to an invalid choice to repeat loop
                continue;
            }

            switch (choice) {
                case 1:
                    handler.accessHandlerModule(scanner);
                    break;
                case 2:
                    System.out.println("Exiting Handler Menu. Goodbye, " + handler.getName() + ".");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add a newline for spacing after each interaction
        } while (choice != 2);
    }
}