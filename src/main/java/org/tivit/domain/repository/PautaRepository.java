package org.tivit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tivit.domain.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
