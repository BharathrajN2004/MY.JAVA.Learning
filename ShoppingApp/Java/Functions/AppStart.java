package ShoppingApp.Java.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ShoppingApp.Java.Components.CartItem;
import ShoppingApp.Java.Components.Product;
import ShoppingApp.Java.Data.Data;

public class AppStart {
    List<CartItem> cartItems;

    public AppStart() {
        cartItems = new ArrayList<>();
    }

    public void displayOptions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Online Shopping System -----");
            System.out.println("1. Show Products");
            System.out.println("2. Show Shopping Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    showShoppingCart();
                    break;
                case 3:
                    addProductToCart(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void showProducts() {
        System.out.println("----- Available Products -----");
        System.out.println("ProductID | Name       | Unit | Price");
        System.out.println("---------------------------------------");
        for (Product product : Data.products) {
            System.out.printf("%-9d | %-10s | %-4s | %.2f%n", product.productId, product.name, product.unit,
                    product.price);
        }
        System.out.println();
    }

    public void showShoppingCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            return;
        }

        System.out.println("----- Shopping Cart -----");
        System.out.println("ProductID | Name       | Unit | Quantity | Price");
        System.out.println("-----------------------------------------------");
        double cartTotal = 0;
        for (CartItem cartItem : cartItems) {
            double total = cartItem.calculateTotal();
            cartTotal += total;
            System.out.printf("%-9d | %-10s | %-4s | %-8.2f | %.2f%n", cartItem.product.productId,
                    cartItem.product.name, cartItem.product.unit, cartItem.quantity, total);
        }
        System.out.println("-----------------------------------------------");
        System.out.printf("Total: %.2f%n", cartTotal);
        System.out.println();
    }

    public void addProductToCart(Scanner scanner) {
        showProducts();
        System.out.print("Enter the ProductID you want to add to the cart: ");
        int productId = scanner.nextInt();

        Product selectedProduct = null;
        for (Product product : Data.products) {
            if (product.productId == productId) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Invalid ProductID. Please try again.");
            return;
        }

        System.out.print("Enter the quantity required: ");
        double quantity = scanner.nextDouble();

        cartItems.add(new CartItem(selectedProduct, quantity));
        System.out.println("Product added to the cart successfully!");
        System.out.println();
    }
}
