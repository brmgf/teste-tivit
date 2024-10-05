package org.tivit.api.disassembler;

import org.springframework.stereotype.Component;
import org.tivit.api.input.AssociadoInput;
import org.tivit.domain.model.Associado;

@Component
public class AssociadoInputDisassembler implements InputDisassembler<Associado, AssociadoInput> {

    @Override
    public Associado toObjectModel(AssociadoInput input) {
        return Associado.builder()
                .nome(input.getNome())
                .build();
    }
}
