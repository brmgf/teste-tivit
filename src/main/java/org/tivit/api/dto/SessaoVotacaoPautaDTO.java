package org.tivit.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SessaoVotacaoPautaDTO {

    private Long id;
    private PautaDTO pauta;
    private LocalDateTime fim;
}
