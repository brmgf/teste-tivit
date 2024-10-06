package org.tivit.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tivit.api.input.VotoInput;
import org.tivit.domain.exception.NegocioException;
import org.tivit.domain.model.TipoVoto;
import org.tivit.domain.model.Voto;
import org.tivit.domain.repository.VotoRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VotacaoService {

    private final VotoRepository repository;
    private final ConsultaSessoesAbertasService sessoesAbertasService;
    private final ConsultaAssociadoService associadoService;

    @Transactional
    public void votar(VotoInput input, Long idSessao) {
        try {
            Voto voto = this.montarObjeto(input, idSessao);
            this.validarVotoAssociado(voto.getAssociado().getId(), voto.getSessao().getPauta().getId());
            repository.save(voto);
        } catch (NegocioException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    private Voto montarObjeto(VotoInput input, Long idSessao) {
        Voto voto = new Voto();
        voto.setSessao(sessoesAbertasService.buscarSessaoAbertaPorId(idSessao));
        voto.setAssociado(associadoService.buscar(input.getAssociadoId()));
        voto.setTipoVoto(TipoVoto.fromDescricao(input.getTipoVoto()));
        return voto;
    }

    private void validarVotoAssociado(Long associadoId, Long idSessao) {
        Optional<Voto> votoDoAssociadoNaSessao = repository
                .findByAssociadoIdAndPautaId(associadoId, idSessao);

        if (votoDoAssociadoNaSessao.isPresent()) {
            throw new NegocioException("O associado já votou nessa pauta.");
        }
    }
}
