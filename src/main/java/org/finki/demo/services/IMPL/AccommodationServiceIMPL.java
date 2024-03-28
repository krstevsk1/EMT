package org.finki.demo.services.IMPL;

import lombok.AllArgsConstructor;
import org.finki.demo.models.Accommodation;
import org.finki.demo.models.DTOs.AccommodationDTO;
import org.finki.demo.repositories.AccommodationRepo;
import org.finki.demo.repositories.HostRepo;
import org.finki.demo.services.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccommodationServiceIMPL implements AccommodationService {

    private final AccommodationRepo accommodationRepo;

    private final HostRepo hostRepo;

    @Override
    public Accommodation addAccommodation(AccommodationDTO accommodationDTO) throws Exception {
        Accommodation accommodation = new Accommodation(
                accommodationDTO.name(),
                accommodationDTO.category(),
                hostRepo.findById(accommodationDTO.hostId()).orElseThrow(Exception::new),
                accommodationDTO.availableRooms()
        );
        return accommodationRepo.save(accommodation);
    }

    @Override
    public Optional<Accommodation> deleteAccommodation(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> editAccommodation(Long id, AccommodationDTO accommodationDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> markRented(Long id) {
        return Optional.empty();
    }

    @Override
    public Accommodation findAccommodation(Long id) {
        return null;
    }
}
