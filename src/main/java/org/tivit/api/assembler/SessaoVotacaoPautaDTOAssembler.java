package org.tivit.api.assembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tivit.api.controller.dto.SessaoVotacaoPautaDTO;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.model.SessaoVotacao;

@RequiredArgsConstructor
@Component
public class SessaoVotacaoPautaDTOAssembler {

    private final PautaDTOAssembler pautaDTOAssembler;

    public SessaoVotacaoPautaDTO toDTO(SessaoVotacao sessaoVotacao, Pauta pauta) {
        return SessaoVotacaoPautaDTO.builder()
                .id(sessaoVotacao.getId())
                .pauta(pautaDTOAssembler.toDTO(pauta))
                .fim(sessaoVotacao.getFim())
                .build();
    }

}
