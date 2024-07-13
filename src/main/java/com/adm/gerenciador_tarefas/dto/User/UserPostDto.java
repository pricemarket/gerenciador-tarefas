package com.adm.gerenciador_tarefas.dto.User;

import com.adm.gerenciador_tarefas.model.Documento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDto {
    @JsonProperty("chaveDeAcesso")
    @NotBlank(message = "Chave de acesso deve ser obrigatório!")
    private String chaveDeAcesso;
    @JsonProperty("name")
    @NotBlank(message = "Nome deve ser obrigatório!")
    private String name;
    @JsonProperty("email")
    @NotBlank(message = "Email deve ser obrigatório!")
    private String email;
    @JsonProperty("cpf")
    @NotBlank(message = "Cpf deve ser obrigatório!")
    private String cpf;
    @JsonProperty("profissao")
    @NotBlank(message = "Profisssão deve ser obrigatório!")
    private String profissao;
    @JsonProperty("sexo")
    @NotBlank(message = "Sexo deve ser obrigatório!")
    private String sexo;
    @JsonProperty("documentos")
    private Set<Documento> documentos;
}
