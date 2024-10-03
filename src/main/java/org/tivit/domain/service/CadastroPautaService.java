package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.repository.PautaRepository;

@RequiredArgsConstructor
@Service
public class CadastroPautaService {

    private final PautaRepository repository;

    @Transactional
    public void cadastrar(Pauta pauta) {
        repository.save(pauta);
    }
}
