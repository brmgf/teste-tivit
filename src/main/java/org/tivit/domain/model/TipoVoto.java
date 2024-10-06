package org.tivit.domain.model;

import org.tivit.domain.exception.NegocioException;

public enum TipoVoto {

    SIM("Sim"), NAO("Não");

    private String descricao;

    TipoVoto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoVoto fromDescricao(String descricao) {
        for (TipoVoto tipo : TipoVoto.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new NegocioException("Voto inválido: " + descricao);
    }
}
