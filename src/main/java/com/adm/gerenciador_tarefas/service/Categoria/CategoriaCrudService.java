package com.adm.gerenciador_tarefas.service.Categoria;

import com.adm.gerenciador_tarefas.dto.Categoria.CategoriaPostDto;
import com.adm.gerenciador_tarefas.model.Categoria;

import java.util.List;

public interface CategoriaCrudService {
    Categoria categoriaCreate(CategoriaPostDto companyDto);
    void categoriaDelete(Long id);
    Categoria categoriaFindById(Long id);
    List<Categoria> categoriaFindAll();
}
