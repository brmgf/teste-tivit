package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.domain.model.Associado;
import org.tivit.domain.repository.AssociadoRepository;

@RequiredArgsConstructor
@Service
public class CadastroAssociadoService {

    private final AssociadoRepository repository;

    @Transactional
    public Associado salvar(Associado associado) {
        return repository.save(associado);
    }
}
