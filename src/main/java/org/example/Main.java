package org.example;

import org.example.people.Visitor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap; // Use LinkedHashMap to preserve insertion order for display
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    // Define access permissions for each role based on the image (e.g., Visitor - 23 means modules 2 and 3)
    private static final Set<Integer> VISITOR_MODULES = new HashSet<>(Arrays.asList(2, 3));
    private static final Set<Integer> MANAGER_MODULES = new HashSet<>(Arrays.asList(1, 2, 3));
    private static final Set<Integer> HANDLER_MODULES = new HashSet<>(Arrays.asList(1, 2, 3));
    private static final Set<Integer> VENDOR_MODULES = new HashSet<>(Arrays.asList(3));
    private static final Set<Integer> VETERINARIAN_MODULES = new HashSet<>(Arrays.asList(3));

    public static void main(String[] args) {
        runZooSystem();
    }

    public static void runZooSystem() {
        int roleChoice;
        do {
            displayStartingPointMenu();
            roleChoice = getUserChoice();

            switch (roleChoice) {
                case 1: // Visitor
                    System.out.println("You selected Visitor.");
                    handleModules(VISITOR_MODULES, "Visitor");
                    break;
                case 2: // Manager
                    System.out.println("You selected Manager.");
                    handleModules(MANAGER_MODULES, "Manager");
                    break;
                case 3: // Handler
                    System.out.println("You selected Handler.");
                    handleModules(HANDLER_MODULES, "Handler");
                    break;
                case 4: // Vendor
                    System.out.println("You selected Vendor.");
                    handleModules(VENDOR_MODULES, "Vendor");
                    break;
                case 5: // Veterinarian
                    System.out.println("You selected Veterinarian.");
                    handleModules(VETERINARIAN_MODULES, "Veterinarian");
                    break;
                case 6: // Exit
                    System.out.println("Exiting Zoo System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (roleChoice != 6);

        scanner.close();
    }

    private static void displayStartingPointMenu() {
        System.out.println("--- ZOO MAIN MENU ---");
        System.out.println("Are you a:");
        System.out.println("1. Visitor");
        System.out.println("2. Manager");
        System.out.println("3. Handler");
        System.out.println("4. Vendor");
        System.out.println("5. Veterinarian");
        System.out.println("6. Exit");
        System.out.print("Enter your role choice: ");
    }


    private static void handleModules(Set<Integer> allowedModules, String roleName) {
        int userChoice;
        Map<Integer, Integer> currentMenuMap;
        int actualModuleId;

        do {
            currentMenuMap = displayZooModulesMenu(allowedModules);
            userChoice = getUserChoice();

            if (currentMenuMap.containsKey(userChoice)) {
                actualModuleId = currentMenuMap.get(userChoice);

                if (actualModuleId == 4) {
                    System.out.println("Exiting " + roleName + " modules. Returning to role selection.");
                    break;
                }

                switch (actualModuleId) {
                    case 1:
                        System.out.println("Entering Zoo Admin Module (you will need to log in)...");
                        ZooAdminModule.runAdminModule();
                        break;
                    case 2:
                        System.out.println("Entering Zoo Ticketing Module...");
                        if (roleName.equals("Visitor")) {
                            //zoo ticketing module
                            System.out.println("[NOTICE] TICKETING FOR VISITORS NOT YET IMPLEMENTED");
                        } else {
                            System.out.println("[NOTICE] TICKETING FOR STAFF NOT IMPLEMENTED (not even sure if its supposed to be..)");
                        }
                        break;
                    case 3:
                        System.out.println("\n\n [WARNING] ZOO MODULE NOT YET IMPLEMENTED. \n\n");
                        //zoo module
                        break;
                    default:
                        System.out.println("Unexpected module ID: " + actualModuleId);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please enter a number from the menu.");
            }
            System.out.println();
        } while (true);
    }

    private static Map<Integer, Integer> displayZooModulesMenu(Set<Integer> allowedModules) {
        System.out.println("\n--- Choose between: ---");
        Map<Integer, Integer> displayToActualModuleMap = new LinkedHashMap<>();
        int displayNum = 1;


        if (allowedModules.contains(1)) {
            System.out.println(displayNum + ". Zoo Admin Module");
            displayToActualModuleMap.put(displayNum, 1);
            displayNum++;
        }

        if (allowedModules.contains(2)) {
            System.out.println(displayNum + ". Zoo Ticketing Module");
            displayToActualModuleMap.put(displayNum, 2);
            displayNum++;
        }

        if (allowedModules.contains(3)) {
            System.out.println(displayNum + ". Zoo Module - ask first for ticket number");
            displayToActualModuleMap.put(displayNum, 3);
            displayNum++;
        }


        System.out.println(displayNum + ". Exit (back to role selection)");
        displayToActualModuleMap.put(displayNum, 4);

        System.out.print("Enter your module choice: ");
        return displayToActualModuleMap;
    }



    /**
     * Helper method to get integer input from the user.
     * Handles NumberFormatException for invalid input.
     */
    private static int getUserChoice() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1; // invalid choice to re-prompt
        }
    }
}