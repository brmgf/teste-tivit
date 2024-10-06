package org.tivit.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tivit.api.input.VotoInput;
import org.tivit.domain.service.VotacaoService;

@RequiredArgsConstructor
@RequestMapping("/sessoes")
@RestController
public class VotosController {

    private final VotacaoService votacaoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idSessao}/votos")
    public void votar(@PathVariable Long idSessao, @RequestBody @Valid VotoInput input) {
        votacaoService.votar(input, idSessao);
    }
}
