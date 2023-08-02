package ShoppingApp.Components;

import java.util.List;

public class Discount {
    public int discountId;
    public List<Integer> productIds;
    public String name;
    public String effectiveStartDate;
    public String effectiveEndDate;

    public Discount(int discountId, List<Integer> productIds, String name, String effectiveStartDate,
            String effectiveEndDate) {
        this.discountId = discountId;
        this.productIds = productIds;
        this.name = name;
        this.effectiveStartDate = effectiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
    }
}
