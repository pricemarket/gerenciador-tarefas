package com.adm.gerenciador_tarefas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_documento")
public class Documento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_doc")
    private Long id;

    @JsonProperty("nomedoc")
    @Column(name="nomedoc", nullable = false)
    private String nomedoc;

    @JsonProperty("link")
    @Column(name = "link", nullable = false)
    private String link;
}