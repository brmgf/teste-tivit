package org.tivit.api.assembler;

import org.springframework.stereotype.Component;
import org.tivit.api.dto.SessaoVotacaoSimplificadaDTO;
import org.tivit.core.util.ConversorData;
import org.tivit.domain.model.SessaoVotacao;

import java.util.Collection;
import java.util.List;

@Component
public class SessaoVotacaoSimplificadaDTOAssembler implements DTOAssembler<SessaoVotacaoSimplificadaDTO, SessaoVotacao> {


    @Override
    public SessaoVotacaoSimplificadaDTO toDTO(SessaoVotacao sessaoVotacao) {
        return SessaoVotacaoSimplificadaDTO.builder()
                .id(sessaoVotacao.getId())
                .inicio(ConversorData.converterLocalDateTimeParaString(sessaoVotacao.getInicio()))
                .fim(ConversorData.converterLocalDateTimeParaString(sessaoVotacao.getFim()))
                .build();
    }

    @Override
    public List<SessaoVotacaoSimplificadaDTO> toCollectionDTO(Collection<SessaoVotacao> sessoesVotacao) {
        return sessoesVotacao.stream().map(this::toDTO).toList();
    }
}
