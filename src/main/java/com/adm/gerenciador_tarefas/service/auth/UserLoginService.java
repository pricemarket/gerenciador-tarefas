package com.adm.gerenciador_tarefas.service.auth;

import com.adm.gerenciador_tarefas.dto.auth.LoginDto;

@FunctionalInterface
public interface UserLoginService {
    boolean authenticate(LoginDto loginDto);
}
