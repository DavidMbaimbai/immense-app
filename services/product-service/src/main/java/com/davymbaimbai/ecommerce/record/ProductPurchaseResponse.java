package com.davymbaimbai.ecommerce.record;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        int unitsInStock
) {
}
