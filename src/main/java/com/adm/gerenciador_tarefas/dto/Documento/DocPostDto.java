package com.adm.gerenciador_tarefas.dto.Documento;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocPostDto {
    @JsonProperty("nomedoc")
    @NotBlank(message = "Nome do documento deve ser obrigatório")
    private String nomedoc;

    @JsonProperty("link")
    @NotBlank(message = "Link ser obrigatório")
    private String link;
}
