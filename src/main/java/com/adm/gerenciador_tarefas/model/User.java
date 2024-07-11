package com.adm.gerenciador_tarefas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "tb_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long ID;
    @JsonProperty("chaveDeAcesso")
    @Column(name = "ds_chaveDeAcesso", nullable = false)
    private String chaveDeAcesso;
    @JsonProperty("name")
    @Column(name="ds_name", nullable = false)
    private String name;
    @JsonProperty("cpf")
    @Column(name="ds_cpf", nullable = false)
    private String cpf;
    @JsonProperty("email")
    @Column(name="ds_email", nullable = false)
    private String email;
    @JsonProperty("profissao")
    @Column(name="ds_profissao", nullable = false)
    private String profissao;
    @JsonProperty
    @Column(name="ds_sexo", nullable = false)
    private String sexo;
}
