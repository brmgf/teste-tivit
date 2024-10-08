package org.tivit.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResultadoDTO {

    private String descricaoPauta;
    private int quantidadeVotosSim;
    private int quantidadeVotosNao;
}
