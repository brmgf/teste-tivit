package org.tivit.api.controller.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessaoVotacaoInput {

    @NotNull(message = "É obrigatório informar uma pauta para iniciar uma sessão")
    private Long pautaId;

    private String fim;
}
