import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine();

        while (true) {
            vendingMachine.displayProducts();
            System.out.println("Current Balance: $" + vendingMachine.getBalance());
            System.out.print("Enter selection (e.g., '0' for the first item, 'n' for nutritional facts, 'm' to insert money, 'q' to quit): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("q")) {
                break;
            }

            if (input.equals("n")) {
                System.out.print("Enter the product index for nutritional facts: ");
                int productIndex = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                vendingMachine.displayNutritionalFacts(productIndex);
            } else if (input.equals("m")) {
                System.out.print("Enter the amount to insert: $");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
                vendingMachine.insertMoney(amount);
                System.out.println("Balance updated. Current Balance: $" + vendingMachine.getBalance());
            } else if (input.matches("\\d+")) {
                int productIndex = Integer.parseInt(input);
                vendingMachine.purchaseItem(productIndex);
            } else {
                System.out.println("Invalid input. Please enter a valid selection.");
            }
        }

        // Display a thank you message.
        System.out.println("Thank you for your purchases!");
        scanner.close();
    }
}




