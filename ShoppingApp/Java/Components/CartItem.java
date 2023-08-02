package ShoppingApp.Java.Components;

public class CartItem {
    Product product;
    double quantity;

    CartItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double calculateTotal() {
        double total = product.price * quantity;
        return total;
    }
}
