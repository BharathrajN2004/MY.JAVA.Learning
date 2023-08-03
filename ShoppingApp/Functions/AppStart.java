package ShoppingApp.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ShoppingApp.Components.CartItem;
import ShoppingApp.Components.Discount;
import ShoppingApp.Components.Product;
import ShoppingApp.Data.Data;

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

    public static void showProducts() {
        System.out.println("----- Available Products -----");
        System.out.println("ProductID | Name       | Unit | Price | Discount");
        System.out.println("-----------------------------------------------");
        for (Product product : Data.products) {
            System.out.printf("%-9d | %-10s | %-4s | %.2f | ", product.productId, product.name, product.unit,
                    product.price);
            boolean hasDiscount = false;
            for (Discount discount : Data.discounts) {
                if (discount.productIds.contains(product.productId)) {
                    System.out.print(discount.name + " (" + discount.effectiveStartDate + " - "
                            + discount.effectiveEndDate + ")");
                    hasDiscount = true;
                    break;
                }
            }
            if (!hasDiscount) {
                System.out.print("No Discount");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showShoppingCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            return;
        }

        System.out.println("----- Shopping Cart -----");
        System.out.println("ProductID | Name       | Unit | Quantity | Price | Discount | Total Price");
        System.out.println("-----------------------------------------------------------------------");
        double cartTotal = 0;
        double cartDiscount = 0;
        for (CartItem cartItem : cartItems) {
            double total = cartItem.calculateTotal();
            double discountAmount = cartItem.calculateDiscountTotal();
            cartTotal += total;
            cartDiscount += discountAmount;
            System.out.printf("%-9d | %-10s | %-4s | %-8.2f | %.2f | ", cartItem.product.productId,
                    cartItem.product.name, cartItem.product.unit, cartItem.quantity, cartItem.product.price);
            String discountInfo = "No Discount";
            for (Discount discountObj : Data.discounts) {
                if (discountObj.productIds.contains(cartItem.product.productId)) {
                    discountInfo = discountObj.name;
                    break;
                }
            }
            System.out.printf("%-9s | %.2f | %.2f%n", discountInfo, discountAmount, total);
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Total Actual Amount: %.2f%n", cartTotal);
        System.out.printf("Total Discount Amount: %.2f%n", cartDiscount);
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Final Cart Total: %.2f%n", cartTotal - cartDiscount);
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

        if (quantity >= 0) {

            boolean notExists = true;
            for (CartItem cart : cartItems) {
                if (cart.product.productId == productId) {
                    cart.quantity += quantity;
                    notExists = false;
                    break;
                }
            }
            if (notExists) {
                cartItems.add(new CartItem(selectedProduct, quantity));
            }

            System.out.println("Product added to the cart successfully!");
            System.out.println();
        } else {
            System.out.println("The quantity cannot be a negative value. Please try again.");
        }
    }
}
