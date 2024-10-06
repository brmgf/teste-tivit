package org.tivit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tivit.domain.model.SessaoVotacao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {

    List<SessaoVotacao> findByFimGreaterThanEqual(LocalDateTime dataHoraAtual);

    Optional<SessaoVotacao> findByIdAndFimGreaterThanEqual(Long id, LocalDateTime dataHoraAtual);
}
