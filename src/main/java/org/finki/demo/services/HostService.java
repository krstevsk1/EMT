package org.finki.demo.services;

import org.finki.demo.models.DTOs.HostDTO;
import org.finki.demo.models.Host;

import java.util.Optional;

public interface HostService {
    Optional<Host> findHost(Long id);

    Host addHost(HostDTO hostDTO) throws Exception;
}
