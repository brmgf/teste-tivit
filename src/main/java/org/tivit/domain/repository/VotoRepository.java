package org.tivit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tivit.domain.model.Voto;

import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query("""
            SELECT 1 FROM Voto v
            JOIN SessaoVotacao sv on sv.id = v.sessao.id
            JOIN Associado a on a.id = v.associado.id
            JOIN Pauta p on p.id = sv.pauta.id
            where a.id = :idAssociado AND p.id = :idPauta
            """)
    Optional<Voto> findByAssociadoIdAndPautaId(Long idAssociado, Long idPauta);
}
