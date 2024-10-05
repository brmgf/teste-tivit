package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.domain.model.SessaoVotacao;
import org.tivit.domain.repository.SessaoVotacaoRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaSessoesAbertasService {

    private final SessaoVotacaoRepository repository;

    @Transactional(readOnly = true)
    public List<SessaoVotacao> buscarSessoesAbertas() {
        return repository.findByFimGreaterThanEqual(LocalDateTime.now());
    }
}
