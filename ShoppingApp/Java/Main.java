package ShoppingApp.Java;

import ShoppingApp.Java.Data.Data;
import ShoppingApp.Java.Functions.AppStart;

public class Main {
    public static void main(String[] args) {
        // Need to initialize the data before app function starts
        Data.initializeData();
        AppStart ShoppingAppCart = new AppStart();
        ShoppingAppCart.displayOptions();
    }
}