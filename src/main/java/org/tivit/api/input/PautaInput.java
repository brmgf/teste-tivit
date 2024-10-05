package org.tivit.api.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PautaInput {

    @NotBlank(message = "A descrição da pauta não pode estar em branco.")
    private String descricao;
}
