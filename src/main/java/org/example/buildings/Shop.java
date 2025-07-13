package org.example.buildings;

import java.util.*;

public class Shop {
    public void zooShop() {
        Scanner scanner = new Scanner(System.in);

        List<String> availableProducts = Arrays.asList("Soft Drink", "Popcorn", "Plush Toy", "Keychain");

        HashMap<String, Integer> availableProductPrices = new HashMap<>();
        availableProductPrices.put("Soft Drink", 30);
        availableProductPrices.put("Popcorn", 50);
        availableProductPrices.put("Plush Toy", 120);
        availableProductPrices.put("Keychain", 45);

        int choice;
        int index = 1;

        System.out.println("\n=== Zoo Shop ===");
        System.out.println("Available Products");
        for (int i = 0; i < availableProducts.size(); i++) {
            String productName = availableProducts.get(i);
            System.out.printf("%d. %s – ₱%d%n", i + 1, productName, availableProductPrices.get(productName));
        }

        System.out.print("\nEnter the numbers of the items you want to buy (separate the numbers by a space): ");
        String productSelected = scanner.nextLine();

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

}
