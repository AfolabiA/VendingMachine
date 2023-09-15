import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private Inventory inventory;
    private double balance;
    private double totalPurchaseAmount;
    private double changeAvailable; // New variable to track change available

    public VendingMachine() {
        this.inventory = new Inventory();
        this.balance = 0.0;
        this.totalPurchaseAmount = 0.0;
        this.changeAvailable = 100.0; // Initialize change available to $100 (for example)
    }

    public void displayProducts() {
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available Products:");
        List<Product> products = inventory.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("[" + i + "] " + product.getName() + " - $" + product.getPrice());
        }
    }

    public void insertMoney(double amount) {
        balance += amount;
    }

    public void purchaseItem(int productIndex) {
        List<Product> products = inventory.getProducts();
        if (productIndex >= 0 && productIndex < products.size()) {
            Product product = products.get(productIndex);
            if (product.getPrice() <= balance) {
                balance -= product.getPrice();
                totalPurchaseAmount += product.getPrice();
                System.out.println("Enjoy your " + product.getName() + "!");
                products.remove(productIndex);
                // Calculate and return change
                double change = balance;
                balance = 0.0; // Reset balance
                giveChange(change);
            } else {
                System.out.println("Insufficient balance. Please insert more money.");
            }
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private void giveChange(double change) {
        if (change <= changeAvailable) {
            changeAvailable -= change;
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("Sorry, we don't have enough change available.");
            balance += change; // Return the balance to the customer
        }
    }

    public void displayNutritionalFacts(int productIndex) {
        List<Product> products = inventory.getProducts();
        if (productIndex >= 0 && productIndex < products.size()) {
            Product product = products.get(productIndex);
            System.out.println("Nutritional Facts for " + product.getName() + ":");
            System.out.println(product.getNutritionalFacts());
        } else {
            System.out.println("Invalid selection.");
        }
    }

    public double getBalance() {
        return balance;
    }
}



