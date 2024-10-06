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
import org.tivit.api.assembler.AssociadoDTOAssembler;
import org.tivit.api.disassembler.AssociadoInputDisassembler;
import org.tivit.api.dto.AssociadoDTO;
import org.tivit.api.input.AssociadoInput;
import org.tivit.domain.service.CadastroAssociadoService;
import org.tivit.domain.service.ConsultaAssociadoService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/associados")
@RestController
public class AssociadoController {

    private final CadastroAssociadoService cadastroService;
    private final ConsultaAssociadoService consultaService;
    private final AssociadoInputDisassembler disassembler;
    private final AssociadoDTOAssembler assembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AssociadoDTO salvar(@RequestBody @Valid AssociadoInput input) {
        return assembler.toDTO(cadastroService.salvar(disassembler.toObjectModel(input)));
    }

    @GetMapping
    public List<AssociadoDTO> listar() {
        return assembler.toCollectionDTO(consultaService.listar());
    }
}
