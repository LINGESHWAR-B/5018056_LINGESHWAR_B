import java.util.*;
class Product {
    private final int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
    }
}

class Inventory {
    private final Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, String productName, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product(1, "Laptop", 10, 1000.0);
        Product product2 = new Product(2, "Smartphone", 50, 500.0);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        System.out.println("All Products:");
        for (Product product : inventory.getAllProducts()) {
            System.out.println(product);
        }

        inventory.updateProduct(1, "Gaming Laptop", 8, 1200.0);
        System.out.println("Updated Product 1: " + inventory.getProduct(1));

        inventory.deleteProduct(2);
        System.out.println("All Products after deleting Product 2:");
        for (Product product : inventory.getAllProducts()) {
            System.out.println(product);
        }
    }
}
