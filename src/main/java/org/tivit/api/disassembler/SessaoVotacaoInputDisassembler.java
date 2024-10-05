package org.tivit.api.disassembler;

import org.springframework.stereotype.Component;
import org.tivit.api.controller.input.SessaoVotacaoInput;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.model.SessaoVotacao;

import java.time.LocalDateTime;

@Component
public class SessaoVotacaoInputDisassembler implements InputDisassembler<SessaoVotacao, SessaoVotacaoInput> {

    @Override
    public SessaoVotacao toObjectModel(SessaoVotacaoInput input) {
        return SessaoVotacao.builder()
                .pauta(Pauta.builder().id(input.getPautaId()).build())
                .inicio(LocalDateTime.now())
                .build();
    }
}
