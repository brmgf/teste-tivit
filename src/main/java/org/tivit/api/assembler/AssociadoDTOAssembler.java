package org.tivit.api.assembler;

import org.springframework.stereotype.Component;
import org.tivit.api.dto.AssociadoDTO;
import org.tivit.domain.model.Associado;

import java.util.Collection;
import java.util.List;

@Component
public class AssociadoDTOAssembler implements DTOAssembler<AssociadoDTO, Associado> {

    @Override
    public AssociadoDTO toDTO(Associado associado) {
        return AssociadoDTO.builder()
                .id(associado.getId())
                .nome(associado.getNome())
                .build();
    }

    @Override
    public List<AssociadoDTO> toCollectionDTO(Collection<Associado> associados) {
        return associados.stream().map(this::toDTO).toList();
    }
}
