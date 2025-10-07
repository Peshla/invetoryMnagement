package inventorymanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;



public class InventoryManagementSystem {
    private static final ArrayList<Product> inventory = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProductQuantity();
                case 4 -> removeProduct();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addProduct() {
        try {
            System.out.print("Enter Product ID: ");
            int id = getIntInput();
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Quantity: ");
            int quantity = getIntInput();
            System.out.print("Enter Price: ");
            double price = getDoubleInput();

            inventory.add(new Product(id, name, quantity, price));
            System.out.println("✅ Product added successfully!");
        } catch (Exception e) {
            System.out.println("⚠️ Invalid input. Product not added.");
        }
    }

    private static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("\n📦 Product List:");
            for (Product p : inventory) {
                System.out.println(p);
            }
        }
    }

    private static void updateProductQuantity() {
        System.out.print("Enter Product ID to update: ");
        int id = getIntInput();
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.print("Enter new quantity: ");
                int quantity = getIntInput();
                p.setQuantity(quantity);
                System.out.println("✅ Quantity updated.");
                return;
            }
        }
        System.out.println("❌ Product not found.");
    }

    private static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = getIntInput();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.remove(i);
                System.out.println("🗑️ Product removed.");
                return;
            }
        }
        System.out.println("❌ Product not found.");
    }

    // Helper methods for safe input
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid price: ");
            }
        }
    }
}

