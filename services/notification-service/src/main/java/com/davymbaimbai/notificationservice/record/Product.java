package com.davymbaimbai.notificationservice.record;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
