package com.adm.gerenciador_tarefas.service.User;

import com.adm.gerenciador_tarefas.dto.Documento.DocPostDto;

@FunctionalInterface
public interface UserAdicionarDocumentoService {
    void adicionardoc(String email, DocPostDto docPostDto);
}