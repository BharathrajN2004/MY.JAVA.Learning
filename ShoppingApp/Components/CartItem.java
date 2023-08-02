package ShoppingApp.Components;

import java.time.LocalDate;

import ShoppingApp.Data.Data;

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

    public double calculateDiscountTotal() {
        double discountAmount = 0;
        for (Discount discount : Data.discounts) {
            if (discount.productIds.contains(product.productId)) {
                discountAmount += calculateDiscountAmount(discount);
            }
        }
        return discountAmount;
    }

    private double calculateDiscountAmount(Discount discount) {
        if (discount.effectiveEndDate != null) {
            // Check if the discount is currently active
            LocalDate startDate = LocalDate.parse(discount.effectiveStartDate);
            LocalDate endDate = LocalDate.parse(discount.effectiveEndDate);
            LocalDate today = LocalDate.now();
            if (today.isBefore(startDate) || today.isAfter(endDate)) {
                return 0;
            }
        }

        double discountAmount = 0;
        if (discount.name.equals("Buy 1 Get 1 Free")) {
            discountAmount = (int) (quantity / 2) * product.price;
        } else if (discount.name.equals("Buy 2 Get 1 Free")) {
            discountAmount = (int) (quantity / 3) * product.price;
        }
        return discountAmount;
    }

}
