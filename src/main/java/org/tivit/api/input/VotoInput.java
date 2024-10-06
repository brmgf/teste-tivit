package org.tivit.api.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.tivit.domain.model.Voto;

@Setter
@Getter
public class VotoInput {

    @NotNull(message = "É obrigatório informar o associado.")
    private Long associadoId;

    @NotNull(message = "Forneça um voto válido.")
    private Voto.TipoVoto tipoVoto;
}
