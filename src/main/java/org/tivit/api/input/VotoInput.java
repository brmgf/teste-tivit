package org.tivit.api.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VotoInput {

    @NotNull(message = "É obrigatório informar o associado.")
    private Long associadoId;

    @NotNull(message = "Forneça um voto válido.")
    private String tipoVoto;
}
