package org.finki.demo.repositories;

import org.finki.demo.models.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation, Long> {
}
