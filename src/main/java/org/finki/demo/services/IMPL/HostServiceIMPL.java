package org.finki.demo.services.IMPL;

import lombok.AllArgsConstructor;
import org.finki.demo.models.DTOs.HostDTO;
import org.finki.demo.models.Host;
import org.finki.demo.repositories.CountryRepo;
import org.finki.demo.repositories.HostRepo;
import org.finki.demo.services.HostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HostServiceIMPL implements HostService {

    private final HostRepo hostRepo;

    private final CountryRepo countryRepo;

    @Override
    public Optional<Host> findHost(Long id) {
        return hostRepo.findById(id);
    }

    @Override
    public Host addHost(HostDTO hostDTO) throws Exception {
        Host host = new Host(
                hostDTO.name(),
                hostDTO.surname(),
                countryRepo.findById(hostDTO.countryId()).orElseThrow(Exception::new)
        );
        return hostRepo.save(host);
    }
}
