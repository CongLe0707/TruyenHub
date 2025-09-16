package com.example.TruyenHub.dto.res;

import java.util.UUID;

public record AuthorRes (
        UUID id,
        String name,
        String bio
) {
}
