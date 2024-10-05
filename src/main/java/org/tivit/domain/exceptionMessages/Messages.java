package org.tivit.domain.exceptionMessages;

public class Messages {

    public static final String ERRO_CONVERTER_DATA_HORA_FIM_SESSAO_VOTACAO =
            "Ocorreu um erro ao converter a data final da sessão. " +
            "Certifique-se que a data está no formato dd/mm/aaaa hh:mm e tente novamente.";
    public static final String ERRO_DATA_HORA_FIM_SESSAO_VOTACAO_ANTERIOR_DATA_HORA_INICIO =
            "A data final da sessão não pode ser anterior a data inicial.";
}
