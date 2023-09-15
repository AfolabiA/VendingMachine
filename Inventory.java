import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
        // Initialize the inventory with hardcoded products
        loadProducts();
    }

    private void loadProducts() {
        products.add(new Product("Cola", 1.50, Category.SODA, "Calories: 150"));
        products.add(new Product("Chips", 1.00, Category.CHIPS, "Calories: 200"));
        products.add(new Product("Cookies", 1.25, Category.COOKIES, "Calories: 180"));
        products.add(new Product("Candy", 0.75, Category.CANDY, "Calories: 120"));
        products.add(new Product("Gum", 0.50, Category.GUM, "Calories: 5"));
        products.add(new Product("Crackers", 1.10, Category.CRACKERS, "Calories: 90"));
        // Add more products here...
    }

    public List<Product> getProducts() {
        return products;
    }
}





