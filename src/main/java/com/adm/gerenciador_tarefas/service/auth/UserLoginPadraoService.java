package com.adm.gerenciador_tarefas.service.auth;

import com.adm.gerenciador_tarefas.dto.auth.LoginDto;
import com.adm.gerenciador_tarefas.model.User;
import com.adm.gerenciador_tarefas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginPadraoService implements UserLoginService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null && user.getChaveDeAcesso().equals(loginDto.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
