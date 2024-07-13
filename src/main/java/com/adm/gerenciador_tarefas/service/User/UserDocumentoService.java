package com.adm.gerenciador_tarefas.service.User;

import com.adm.gerenciador_tarefas.dto.Documento.DocPostDto;
import com.adm.gerenciador_tarefas.model.Documento;

import java.util.Set;

public interface UserDocumentoService {
    void adicionardoc(String email, DocPostDto docPostDto);
    Set<Documento> buscarTodosDoc(String email);
}