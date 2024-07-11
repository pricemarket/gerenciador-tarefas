package com.adm.gerenciador_tarefas.exception.Categoria;

import com.adm.gerenciador_tarefas.exception.CommerceException;

public class CategoriaNaoExisteException extends CommerceException {
    public CategoriaNaoExisteException() {super("Categoria não existe!");}
}
