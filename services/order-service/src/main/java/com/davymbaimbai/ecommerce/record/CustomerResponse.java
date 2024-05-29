package com.davymbaimbai.ecommerce.record;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
