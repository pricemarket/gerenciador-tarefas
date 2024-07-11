package com.adm.gerenciador_tarefas.exception.Validacao;

import com.adm.gerenciador_tarefas.exception.CommerceException;

public class CodigoDeBarrasInvalidoException extends CommerceException {
    public CodigoDeBarrasInvalidoException() {
        super("Código de Barras Inválido!");
    }
}
