package com.adm.gerenciador_tarefas.exception.Validacao;

import com.adm.gerenciador_tarefas.exception.CommerceException;

public class CodigoAcessoInvalidoException extends CommerceException {
    public CodigoAcessoInvalidoException() {
        super("Código Acesso Inválido");
    }
}
