package ShoppingApp.Java.Components;

import java.util.List;

public class Discount {
    int discountId;
    List<Integer> productIds;
    String name;
    String effectiveStartDate;
    String effectiveEndDate;

    public Discount(int discountId, List<Integer> productIds, String name, String effectiveStartDate,
            String effectiveEndDate) {
        this.discountId = discountId;
        this.productIds = productIds;
        this.name = name;
        this.effectiveStartDate = effectiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
    }
}
