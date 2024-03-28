package org.finki.demo.models.DTOs;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import org.finki.demo.models.Country;

public record HostDTO(
        String name,
        String surname,
        Long countryId
) {
}
