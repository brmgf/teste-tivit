package org.tivit.domain.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.api.disassembler.SessaoVotacaoInputDisassembler;
import org.tivit.api.input.SessaoVotacaoInput;
import org.tivit.core.util.ConversorData;
import org.tivit.domain.exception.NegocioException;
import org.tivit.domain.exceptionMessages.Messages;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.model.SessaoVotacao;
import org.tivit.domain.repository.SessaoVotacaoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AbrirSessaoVotacaoService {

    private final ConsultaPautaService consultaPautaService;
    private final SessaoVotacaoInputDisassembler disassembler;
    private final SessaoVotacaoRepository repository;

    @Transactional
    public SessaoVotacao salvarSessao(@Valid SessaoVotacaoInput input) {
        this.validarSessaoAbertaParaPauta(input.getPautaId());
        SessaoVotacao sessaoVotacao = disassembler.toObjectModel(input);
        sessaoVotacao.setFim(this.getDataHoraFimSessaoVotacao(input.getFim()));
        return repository.save(sessaoVotacao);
    }

    private void validarSessaoAbertaParaPauta(Long idPauta) {
        Pauta pauta = consultaPautaService.buscar(idPauta);
        Optional<SessaoVotacao> sessaoVotacaoAberta = repository
                .findSessaoAbertaByPautaId(pauta.getId(), LocalDateTime.now());

        if (sessaoVotacaoAberta.isPresent()) {
            throw new NegocioException("Já existe uma sessão aberta para essa pauta.");
        }
    }

    private LocalDateTime getDataHoraFimSessaoVotacao(String fim) {
        if (Objects.isNull(fim) || fim.trim().isEmpty()) {
            return LocalDateTime.now().plusMinutes(1L);
        }

        LocalDateTime dataFim = this.tentarConverterDataFim(fim);
        this.validarDataHoraFimSessaoVotacao(dataFim);
        return dataFim;
    }

    private LocalDateTime tentarConverterDataFim(String fim) throws NegocioException {
        try {
            return ConversorData.converterStringParaLocalDateTime(fim);
        } catch (DateTimeParseException ex) {
            log.error("Erro ao converter a string para LocalDateTime: " + ex.getMessage());
            throw new NegocioException(Messages.ERRO_CONVERTER_DATA_HORA_FIM_SESSAO_VOTACAO);
        }
    }

    private void validarDataHoraFimSessaoVotacao(LocalDateTime dataHoraFim) throws NegocioException {
        if (dataHoraFim.isBefore(LocalDateTime.now().minusMinutes(1L))) {
            log.error("Hora fim fornecida é anterior a data de início da sessão");
            throw new NegocioException(Messages.ERRO_DATA_HORA_FIM_SESSAO_VOTACAO_ANTERIOR_DATA_HORA_INICIO);
        }
    }
}
