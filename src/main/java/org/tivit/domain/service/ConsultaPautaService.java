package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.domain.exception.NegocioException;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.repository.PautaRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaPautaService {

    private final PautaRepository repository;

    @Transactional(readOnly = true)
    public List<Pauta> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Pauta buscar(Long pautaId) {
        return repository.findById(pautaId).orElseThrow(() -> new NegocioException("Pauta não encontrada."));
    }
}
