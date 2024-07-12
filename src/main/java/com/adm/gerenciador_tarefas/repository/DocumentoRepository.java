package com.adm.gerenciador_tarefas.repository;

import com.adm.gerenciador_tarefas.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
