package org.finki.demo.services;

import org.finki.demo.models.Accommodation;
import org.finki.demo.models.DTOs.AccommodationDTO;

import java.util.Optional;

public interface AccommodationService {
    Accommodation addAccommodation(AccommodationDTO accommodationDTO) throws Exception;

    Optional<Accommodation> deleteAccommodation(Long id);

    Optional<Accommodation> editAccommodation(Long id, AccommodationDTO accommodationDTO);

    Optional<Accommodation> markRented(Long id);

    Accommodation findAccommodation(Long id);
}
