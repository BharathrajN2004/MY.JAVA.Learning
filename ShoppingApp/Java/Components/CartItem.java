package ShoppingApp.Java.Components;

public class CartItem {
    public Product product;
    public double quantity;

    public CartItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        double total = product.price * quantity;
        return total;
    }
}
