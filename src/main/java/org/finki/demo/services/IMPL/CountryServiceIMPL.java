package org.finki.demo.services.IMPL;

import lombok.AllArgsConstructor;
import org.finki.demo.models.Country;
import org.finki.demo.models.DTOs.CountryDTO;
import org.finki.demo.repositories.CountryRepo;
import org.finki.demo.services.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceIMPL implements CountryService {

    private final CountryRepo countryRepo;

    @Override
    public Country addCountry(@RequestBody CountryDTO countryDTO) {
        return countryRepo.save(
                new Country(countryDTO.name(), countryDTO.continent())
        );
    }

    @Override
    public Optional<Country> findCountry(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public List<Country> listAll() {
        return countryRepo.findAll();
    }
}
