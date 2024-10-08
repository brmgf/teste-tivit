package org.tivit.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tivit.api.assembler.SessaoVotacaoPautaDTOAssembler;
import org.tivit.api.assembler.SessaoVotacaoSimplificadaDTOAssembler;
import org.tivit.api.dto.SessaoVotacaoPautaDTO;
import org.tivit.api.dto.SessaoVotacaoSimplificadaDTO;
import org.tivit.api.input.SessaoVotacaoInput;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.model.SessaoVotacao;
import org.tivit.domain.service.AbrirSessaoVotacaoService;
import org.tivit.domain.service.ConsultaPautaService;
import org.tivit.domain.service.ConsultaSessoesAbertasService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sessoes")
@RestController
public class SessaoVotacaoController {

    private final AbrirSessaoVotacaoService service;
    private final ConsultaPautaService consultaPautaService;
    private final ConsultaSessoesAbertasService consultaSessoesAbertasService;
    private final SessaoVotacaoPautaDTOAssembler sessaoPautaAssembler;
    private final SessaoVotacaoSimplificadaDTOAssembler sessaoSimplificadaAssembler;

    @GetMapping
    public List<SessaoVotacaoSimplificadaDTO> consultarSessoesAbertas() {
        return sessaoSimplificadaAssembler.toCollectionDTO(consultaSessoesAbertasService.buscarSessoesAbertas());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SessaoVotacaoPautaDTO abrirSessaoVotacao(@RequestBody @Valid SessaoVotacaoInput input) {
        SessaoVotacao sessaoVotacao = service.salvarSessao(input);
        Pauta pautaSessaoVotacao = consultaPautaService.buscar(sessaoVotacao.getPauta().getId());
        return sessaoPautaAssembler.toDTO(sessaoVotacao, pautaSessaoVotacao);
    }
}
