package com.adm.gerenciador_tarefas.service.Categoria;

import com.adm.gerenciador_tarefas.dto.Categoria.CategoriaPostDto;
import com.adm.gerenciador_tarefas.exception.Categoria.CategoriaNaoExisteException;
import com.adm.gerenciador_tarefas.model.Categoria;
import com.adm.gerenciador_tarefas.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaCrudPadraoService implements CategoriaCrudService{
    @Autowired
    private CategoriaRepository categoriaRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Categoria categoriaCreate(CategoriaPostDto categoriaPostDto) {
        return categoriaRepository.save(modelMapper.map(categoriaPostDto, Categoria.class));
    }

    @Override
    public void categoriaDelete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria categoriaFindById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(CategoriaNaoExisteException::new);
    }

    @Override
    public List<Categoria> categoriaFindAll() {
        return categoriaRepository.findAll();
    }
}
