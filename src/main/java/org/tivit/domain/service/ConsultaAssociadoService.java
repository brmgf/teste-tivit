package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.domain.exception.NegocioException;
import org.tivit.domain.model.Associado;
import org.tivit.domain.repository.AssociadoRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaAssociadoService {

    private final AssociadoRepository repository;

    @Transactional(readOnly = true)
    public List<Associado> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Associado buscar(Long idAssociado) {
        return repository.findById(idAssociado)
                .orElseThrow(() -> new NegocioException("Não foi possível encontrar o associado informado."));
    }
}
