package org.tivit.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tivit.api.assembler.PautaDTOAssembler;
import org.tivit.api.disassembler.PautaInputDissassembler;
import org.tivit.api.dto.PautaDTO;
import org.tivit.api.dto.ResultadoDTO;
import org.tivit.api.input.PautaInput;
import org.tivit.domain.service.CadastroPautaService;
import org.tivit.domain.service.ConsultaPautaService;
import org.tivit.domain.service.ResultadoVotacaoService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pautas")
@RestController
public class PautasController {

    private final CadastroPautaService cadastroPautaService;
    private final ConsultaPautaService consultaPautaService;
    private final ResultadoVotacaoService service;
    private final PautaInputDissassembler dissassembler;
    private final PautaDTOAssembler assembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PautaDTO cadastrar(@RequestBody @Valid PautaInput input) {
        return assembler.toDTO(cadastroPautaService.cadastrar(dissassembler.toObjectModel(input)));
    }

    @GetMapping
    public List<PautaDTO> listar() {
        return assembler.toCollectionDTO(consultaPautaService.listar());
    }

    @GetMapping("/{pautaId}/votos")
    public ResultadoDTO listarResultados(@PathVariable Long pautaId) {
        return service.montarResultado(pautaId);
    }
}
