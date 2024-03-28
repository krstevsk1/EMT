package org.finki.demo.repositories;

import org.finki.demo.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepo extends JpaRepository<Host, Long> {
}
