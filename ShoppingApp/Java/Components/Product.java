package ShoppingApp.Java.Components;

public class Product {
    int productId;
    String name;
    String unit;
    double price;

    public Product(int productId, String name, String unit, double price) {
        this.productId = productId;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }
}
