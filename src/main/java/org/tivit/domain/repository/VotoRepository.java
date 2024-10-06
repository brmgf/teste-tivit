package org.tivit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tivit.domain.model.Voto;

import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    Optional<Voto> findByAssociadoIdAndSessaoId(Long associadoId, Long idSessao);
}
