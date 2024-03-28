package org.finki.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.finki.demo.models.Accommodation;
import org.finki.demo.models.DTOs.AccommodationDTO;
import org.finki.demo.services.AccommodationService;
import org.finki.demo.services.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accommodation")
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final HostService hostService;


    @PostMapping("/add")
    public ResponseEntity<Accommodation> addAccommodation(@NonNull @RequestBody AccommodationDTO dto) throws Exception {

        if(hostService.findHost(dto.hostId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(this.accommodationService.addAccommodation(dto));

    }

    @DeleteMapping("/delete-accommodation/{id}")
    public ResponseEntity<Accommodation> deleteAccommodation(@NonNull @PathVariable Long id) {

        if(accommodationService.findAccommodation(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return this.accommodationService.deleteAccommodation(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit-accommodation/{id}")
    public ResponseEntity<Accommodation> editBook(@NonNull @PathVariable Long id, @NonNull @RequestBody AccommodationDTO accommodationDTO) {

        if(hostService.findHost(accommodationDTO.hostId()).isEmpty() || accommodationService.findAccommodation(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return accommodationService.editAccommodation(id, accommodationDTO).map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/mark-rented/{id}")
    public ResponseEntity<Accommodation> markRented(@NonNull @PathVariable Long id){

        if(accommodationService.findAccommodation(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return this.accommodationService.markRented(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
