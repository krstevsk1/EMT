package org.finki.demo.services;

import org.finki.demo.models.Country;
import org.finki.demo.models.DTOs.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country addCountry(CountryDTO countryDTO);

    Optional<Country> findCountry(Long id);

    List<Country> listAll();
}
