package ShoppingApp;

import ShoppingApp.Data.Data;
import ShoppingApp.Functions.AppStart;

public class Main {
    public static void main(String[] args) {
        // Need to initialize the data before app function starts
        Data.initializeData();
        AppStart ShoppingAppCart = new AppStart();
        ShoppingAppCart.displayOptions();
    }
}