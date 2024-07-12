package com.adm.gerenciador_tarefas.auth;

import com.adm.gerenciador_tarefas.dto.auth.LoginDto;
import com.adm.gerenciador_tarefas.service.auth.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private UserLoginService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        String token = userService.authenticate(loginDto);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Email ou Senha inválido!");
        }
    }
}
