package org.tivit.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tivit.domain.model.TipoVoto;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResultadoVotacaoDTO {

    private TipoVoto tipoVoto;
    private Long quantidade;
}
