package com.adm.gerenciador_tarefas.controller.Categoria;

import com.adm.gerenciador_tarefas.dto.Categoria.CategoriaPostDto;
import com.adm.gerenciador_tarefas.service.Categoria.CategoriaCrudService;
import com.adm.gerenciador_tarefas.model.Categoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {
    @Autowired
    private CategoriaCrudService categoriaCrudService;


    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoriaCrudService.categoriaFindAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoriaCrudService.categoriaFindById(id));
    }
    @PostMapping
    public ResponseEntity<?> createCategoria(@RequestBody @Valid CategoriaPostDto categoriaPostDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaCrudService.categoriaCreate(categoriaPostDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        this.categoriaCrudService.categoriaDelete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }

}
