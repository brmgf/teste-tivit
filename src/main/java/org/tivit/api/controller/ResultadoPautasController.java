package org.tivit.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tivit.api.dto.ResultadoDTO;
import org.tivit.domain.service.ResultadoVotacaoService;

@RequiredArgsConstructor
@RequestMapping("pautas")
@RestController
public class ResultadoPautasController {

    private final ResultadoVotacaoService service;

    @GetMapping("/{pautaId}/resultado")
    public ResultadoDTO listarResultados(@PathVariable Long pautaId) {
        return service.montarResultado(pautaId);
    }
}
