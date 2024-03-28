package org.finki.demo.models.DTOs;

import org.finki.demo.models.Category;

public record AccommodationDTO(
        String name,
        Category category,
        Long hostId,
        Integer availableRooms) {
}
