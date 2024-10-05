package org.tivit.api.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AssociadoInput {

    @NotBlank(message = "É obrigatório informar o nome do associado.")
    private String nome;
}
