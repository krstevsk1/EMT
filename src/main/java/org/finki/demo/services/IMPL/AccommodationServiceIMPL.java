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
    public Accommodation deleteAccommodation(Long id) {
        Accommodation accommodation = accommodationRepo.findById(id).get();
        accommodationRepo.deleteById(id);
        return accommodation;
    }

    @Override
    public Accommodation editAccommodation(Long id, AccommodationDTO accommodationDTO) {
        Accommodation accommodation = accommodationRepo.findById(id).get();
        accommodation.setCategory(accommodationDTO.category());
        accommodation.setHost(hostRepo.findById(accommodationDTO.hostId()).get());
        accommodation.setNumRooms(accommodationDTO.availableRooms());

        return accommodation;
    }

    @Override
    public Accommodation markRented(Long id) {
        Accommodation accommodation = accommodationRepo.findById(id).get();
        accommodation.setRented(!accommodation.isRented());
        return accommodation;
    }

    @Override
    public Accommodation findAccommodation(Long id) {
        return null;
    }
}
