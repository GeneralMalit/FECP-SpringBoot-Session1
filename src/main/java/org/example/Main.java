package org.example;

import org.example.animals.*;
import org.example.people.Handler;
import org.example.people.Visitor;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean zooOpen = false; // Initial state: zoo is closed
    public static ZooModule zoo = new ZooModule(zooOpen);

    // Define access permissions for each role based on the image (e.g., Visitor - 23 means modules 2 and 3)
    private static final Set<Integer> VISITOR_MODULES = new HashSet<>(Arrays.asList(2, 3));
    private static final Set<Integer> MANAGER_MODULES = new HashSet<>(Arrays.asList(1, 2, 3));
    private static final Set<Integer> HANDLER_MODULES = new HashSet<>(Arrays.asList(1, 2, 3));
    private static final Set<Integer> VENDOR_MODULES = new HashSet<>(Arrays.asList(3));
    private static final Set<Integer> VETERINARIAN_MODULES = new HashSet<>(Arrays.asList(3));
    public static final Map<String, String> ANIMAL_NAMES = new LinkedHashMap<>();
    public static void main(String[] args) {
        initializeNames();
        runZooSystem();
    }

    public static void runZooSystem() {
        int roleChoice;
        do {
            displayStartingPointMenu();
            roleChoice = getUserChoice();

            switch (roleChoice) {
                case 1: // Visitor
                    System.out.println("Selected role: Visitor.");
                    handleModules(VISITOR_MODULES, "Visitor");
                    break;
                case 2: // Manager
                    System.out.println("Selected role: Manager.");
                    handleModules(MANAGER_MODULES, "Manager");
                    break;
                case 3: // Handler
                    System.out.println("Selected role: Handler.");
                    handleModules(HANDLER_MODULES, "Handler");
                    break;
                case 4: // Vendor
                    System.out.println("Selected role: Vendor.");
                    handleModules(VENDOR_MODULES, "Vendor");
                    break;
                case 5: // Veterinarian
                    System.out.println("Selected role: Veterinarian.");
                    handleModules(VETERINARIAN_MODULES, "Veterinarian");
                    break;
                case 6: // Exit
                    System.out.println("Exiting Zoo System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add a newline for spacing after each role interaction
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

                if (actualModuleId == 4) { // Exit option
                    System.out.println("Exiting " + roleName + " modules. Returning to role selection.");
                    break;
                }

                switch (actualModuleId) {
                    case 1:
                        System.out.println("Entering Zoo Admin Module...");
                        ZooAdminModule.runAdminModule();
                        break;
                    case 2:
                        if (roleName.equals("Visitor")) {
                            ZooTicketing zooTicketing = new ZooTicketing();
                            zooTicketing.processTicketPurchasing();
                        } else {
                            System.out.println("Access denied: Only Visitors are allowed for Zoo Ticketing.");
                        }
                        break;
                    case 3:
                        if(roleName.equals("Visitor")){
                            System.out.println("=== Visitor Entry ===");
                            System.out.print("Enter your ticket number: ");
                            String ticketCode = scanner.nextLine();
                            if(!ZooTicketing.isTicketValid(ticketCode)){
                                System.out.println("Ticket code is invalid!");
                                // Optionally, return to module menu or main menu here
                                return; // Exit current handleModules invocation to prevent entering zoo
                            }
                            System.out.println("Welcome to Zoo!");
                        }
                        //call zoo module
                        zoo.runZooModule();
                        break;
                    default:
                        System.out.println("Unexpected module ID: " + actualModuleId);
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please enter a number from the menu.");
            }
            System.out.println(); // Add a newline for spacing after each module interaction
        } while (true);
    }

    private static Map<Integer, Integer> displayZooModulesMenu(Set<Integer> allowedModules) {
        System.out.println("--- Choose a Module ---");
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
            System.out.println(displayNum + ". Zoo Module"); // Simplified description
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
            return -1; // Return an invalid choice to re-prompt
        }
    }

    public static void setZooOpen(boolean status) {
        zooOpen = status;
        System.out.println("Zoo status updated: Zoo is now " + (zooOpen ? "OPEN" : "CLOSED") + ".");
    }


    public static boolean isZooOpen() {
        return zooOpen;
    }

    public static void initializeNames(){
        Animal cheetah = new Cheetah("Dash");
        Animal elephant = new Elephant("Trunky");
        Animal falcon = new Falcon("Skye");
        Animal hippo = new Hippo("Bubbles");
        Animal lion = new Lion("Simba");
        Animal owl = new Owl("Hoots");
        Animal parrot = new Parrot("Chatter");
        Animal rhino = new Rhino("Tank");
        Animal tiger = new Tiger("Stripes");
        ANIMAL_NAMES.put("Cheetah", cheetah.getName());
        ANIMAL_NAMES.put("Elephant", elephant.getName());
        ANIMAL_NAMES.put("Falcon", falcon.getName());
        ANIMAL_NAMES.put("Hippo", hippo.getName());
        ANIMAL_NAMES.put("Lion", lion.getName());
        ANIMAL_NAMES.put("Owl", owl.getName());
        ANIMAL_NAMES.put("Parrot", parrot.getName());
        ANIMAL_NAMES.put("Rhino", rhino.getName());
        ANIMAL_NAMES.put("Tiger", tiger.getName());
        // System.out.println(ANIMAL_NAMES.toString()); // Removed
    }
}
