package ShoppingApp.Java.Data;

import java.util.ArrayList;
import java.util.List;

import ShoppingApp.Java.Components.Discount;
import ShoppingApp.Java.Components.Product;

public class Data {
    public static List<Product> products;
    public static List<Discount> discounts;

    public static void initializeData() {

        products = new ArrayList<>();
        products.add(new Product(1, "Banana", "Kg", 100.00));
        products.add(new Product(2, "Orange", "Kg", 230.00));
        products.add(new Product(3, "Apple", "Kg", 330.00));
        products.add(new Product(4, "Grapes", "Kg", 230.00));

        discounts = new ArrayList<>();
        List<Integer> discount1ProductIds = new ArrayList<>();
        discount1ProductIds.add(1);
        discounts.add(new Discount(1, discount1ProductIds, "Buy 1 Get 1 Free", "2023-08-02", "2023-08-10"));

        List<Integer> discount2ProductIds = new ArrayList<>();
        discount2ProductIds.add(2);
        discount2ProductIds.add(3);
        discounts.add(new Discount(2, discount2ProductIds, "Buy 2 Get 1 Free", "2023-08-02", null));
    }
}