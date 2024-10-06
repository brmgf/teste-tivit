package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tivit.api.dto.ResultadoDTO;
import org.tivit.api.dto.ResultadoVotacaoDTO;
import org.tivit.domain.model.Pauta;
import org.tivit.domain.model.TipoVoto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResultadoVotacaoService {

    private final ConsultaPautaService consultaPautaService;
    private final VotacaoService votacaoService;

    public ResultadoDTO montarResultado(Long pautaId) {
        Pauta pauta = consultaPautaService.buscar(pautaId);
        List<ResultadoVotacaoDTO> resultadoVotacao = votacaoService.consultarResultadoPauta(pauta.getId());

        Map<TipoVoto, Integer> votosPorTipo = resultadoVotacao.stream()
                .collect(Collectors.toMap(
                        ResultadoVotacaoDTO::getTipoVoto,
                        resultadoDTO -> resultadoDTO.getQuantidade().intValue()
                ));

        int quantidadeVotosSim = votosPorTipo.getOrDefault(TipoVoto.SIM, 0);
        int quantidadeVotosNao = votosPorTipo.getOrDefault(TipoVoto.NAO, 0);

        return ResultadoDTO.builder()
                .descricaoPauta(pauta.getDescricao())
                .quantidadeVotosSim(quantidadeVotosSim)
                .quantidadeVotosNao(quantidadeVotosNao)
                .build();
    }
}
