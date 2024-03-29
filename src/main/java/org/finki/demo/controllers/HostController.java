package org.finki.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.finki.demo.models.DTOs.HostDTO;
import org.finki.demo.models.Host;
import org.finki.demo.services.CountryService;
import org.finki.demo.services.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/host")
public class HostController {
    private final HostService hostService;
    private final CountryService countryService;



    @PostMapping("/add-host")
    public ResponseEntity<Host> addHost(@NonNull @RequestBody HostDTO hostDTO) throws Exception {

        if(countryService.findCountry(hostDTO.countryId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(hostService.addHost(hostDTO));
    }
}
