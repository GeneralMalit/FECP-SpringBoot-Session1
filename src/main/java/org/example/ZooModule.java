package org.example;

import java.util.*;

public class ZooModule {
    private Scanner scanner;
    private static boolean isOpen = false; //changed to static to make it global.

    public ZooModule() {
        scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Leave Zoo");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Visit Enclosure
                }

                case 2 -> {
                    // Visit Shop
                }

                case 3 -> {
                    // Visit Hospital
                }

                default -> {
                    // exit
                    System.out.println("Invalid option. Please choose a number from 1-4.");
                }
            }
        } while (choice != 4);
        System.out.println("You have left the zoo. 👋");
    }


    private void zooEnclosure() {
        //removed scanner, its already in Main.
        int choice;

        do {
            System.out.println("=== Zoo Enclosure ===");
            System.out.println("Choose Enclosure");
            System.out.println("1. Pachyderm");
            System.out.println("2. Feline");
            System.out.println("3. Bird");
            System.out.println("4. Go Back");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // go to pachyderm enclosure
                }

                case 2 -> {
                    // go to feline enclosure

                }

                case 3 -> {
                    // go to bird enclosure
                }

                default -> {
                    System.out.println("Invalid option. Please choose a number from 1-4.");
                }
            }

        } while (choice != 4);
    }

    private void zooShop() {
        //removed scanner, its already in Main.

        List<String> availableProducts = Arrays.asList("Soft Drink", "Popcorn", "Plush Toy", "Keychain");

        HashMap<String, Integer> availableProductPrices = new HashMap<>();
        availableProductPrices.put("Soft Drink", 30);
        availableProductPrices.put("Popcorn", 50);
        availableProductPrices.put("Plush Toy", 120);
        availableProductPrices.put("Keychain", 45);

        int choice;
        int index = 1;

        System.out.println("=== Zoo Shop ===");
        System.out.println("Available Products");
        for (int i = 0; i < availableProducts.size(); i++) {
            String productName = availableProducts.get(i);
            System.out.printf("%d. %s – ₱%d%n", i + 1, productName, availableProductPrices.get(productName));
        }

        System.out.print("Enter the numbers of the items you want to buy (separate the numbers by a space): ");
        String productSelected = scanner.next();

        String[] productsSelected = productSelected.trim().split("\\s+");

        // no duplicate items, only one of each
        Set<String> selectedItems = new LinkedHashSet<>();
        int total = 0;

        for (String product : productsSelected) {
            try {
                int productNumber = Integer.parseInt(product) - 1;
                if (productNumber >= 0 && productNumber < availableProducts.size()) {
                    String selectedProduct = availableProducts.get(productNumber);
                    if (!selectedItems.contains(selectedProduct)) {
                        selectedItems.add(selectedProduct);
                        total += availableProductPrices.get(selectedProduct);
                    }
                } else {
                    System.out.printf("Invalid selection: %s%n", product);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid input: %s%n", product);
            }
        }

        // Show selected items
        if (selectedItems.isEmpty()) {
            System.out.println("\nNo valid items selected.");
            return;
        }

        System.out.println("\nSelected:");
        for (String item : selectedItems) {
            System.out.printf("%s (₱%d)%n", item, availableProductPrices.get(item));
        }

        System.out.printf("\nTotal: ₱%d%n", total);

        // Confirm checkout
        System.out.print("\nProceed to checkout? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            System.out.println("\nPayment successful!");
            System.out.println("Receipt:");
            for (String item : selectedItems) {
                System.out.printf("- %s: ₱%d%n", item, availableProductPrices.get(item));
            }
            System.out.printf("Total Paid: ₱%d%n", total);
        } else {
            System.out.println("\nCheckout cancelled.");
        }
    }

    private void zooHospital() {
        //removed scanner, its already in Main.
        int choice;

        do {

            System.out.println("=== Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian)");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // view sick animals
                }

                case 2 -> {
                    // view healed animals
                }

                case 3 -> {
                    // attend science lecture
                }

                case 4 -> {
                    // heal animals
                    // check role
                }
                default -> {
                    System.out.println("Invalid option. Please choose a number from 1-5.");
                }
            }
        } while (choice !=5);
    }

    //get and set the zoo's open status
    public static boolean getIsOpen() {
        return isOpen;
    }

    public static void setIsOpen(boolean status) {
        isOpen = status;
        System.out.println("Zoo status (from ZooModule) updated: Zoo is now " + (isOpen ? "OPEN" : "CLOSED"));
    }


}
