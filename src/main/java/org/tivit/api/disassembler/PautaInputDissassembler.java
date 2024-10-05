package org.tivit.api.disassembler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tivit.api.input.PautaInput;
import org.tivit.domain.model.Pauta;

@RequiredArgsConstructor
@Component
public class PautaInputDissassembler implements InputDisassembler<Pauta, PautaInput> {

    @Override
    public Pauta toObjectModel(PautaInput input) {
        return Pauta.builder()
                .descricao(input.getDescricao())
                .build();
    }
}
