package com.example.TruyenHub.dto.res;

import java.util.UUID;

public record CategoryRes (
        UUID id,
        String name,
        String description
) {
}
