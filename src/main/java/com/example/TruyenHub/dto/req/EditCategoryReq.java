package com.example.TruyenHub.dto.req;

import java.util.UUID;

public record EditCategoryReq (
        UUID id,
        String name,
        String description
) {
}
