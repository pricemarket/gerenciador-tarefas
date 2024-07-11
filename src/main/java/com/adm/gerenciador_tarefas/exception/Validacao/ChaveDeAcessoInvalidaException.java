package com.adm.gerenciador_tarefas.exception.Validacao;

import com.adm.gerenciador_tarefas.exception.CommerceException;

public class ChaveDeAcessoInvalidaException extends CommerceException {
    public ChaveDeAcessoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
