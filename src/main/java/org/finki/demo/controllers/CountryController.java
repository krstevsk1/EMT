package org.finki.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.finki.demo.models.Country;
import org.finki.demo.models.DTOs.CountryDTO;
import org.finki.demo.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> addCountry(@NonNull @RequestBody CountryDTO countryDTO){
        if(countryDTO.name() == null || countryDTO.continent() == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(this.countryService.addCountry(countryDTO));
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<Country>> getCountries() {
        var countries = countryService.listAll();

        return ResponseEntity.ok(countries);
    }
}
