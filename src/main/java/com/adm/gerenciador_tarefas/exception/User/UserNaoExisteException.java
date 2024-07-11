package com.adm.gerenciador_tarefas.exception.User;

import com.adm.gerenciador_tarefas.exception.CommerceException;

public class UserNaoExisteException extends CommerceException {
    public UserNaoExisteException() { super("Usuario nao existe"); }
}
