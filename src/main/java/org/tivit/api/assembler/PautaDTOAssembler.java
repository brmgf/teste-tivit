package org.tivit.api.assembler;

import org.springframework.context.annotation.Configuration;
import org.tivit.api.dto.PautaDTO;
import org.tivit.domain.model.Pauta;

import java.util.Collection;
import java.util.List;

@Configuration
public class PautaDTOAssembler implements DTOAssembler<PautaDTO, Pauta> {

    @Override
    public PautaDTO toDTO(Pauta pauta) {
        return PautaDTO.builder()
                .id(pauta.getId())
                .descricao(pauta.getDescricao())
                .build();
    }

    @Override
    public List<PautaDTO> toCollectionDTO(Collection<Pauta> pautas) {
        return pautas.stream().map(this::toDTO).toList();
    }
}
