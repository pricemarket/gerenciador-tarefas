package com.adm.gerenciador_tarefas.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String email;
    private String password;
}
