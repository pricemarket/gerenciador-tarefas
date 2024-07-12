package com.adm.gerenciador_tarefas.controller.User;

import com.adm.gerenciador_tarefas.dto.Documento.DocPostDto;
import com.adm.gerenciador_tarefas.service.User.UserAdicionarDocumentoService;
import com.adm.gerenciador_tarefas.service.User.UserCrudService;
import com.adm.gerenciador_tarefas.dto.User.UserPostDto;
import com.adm.gerenciador_tarefas.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // configurando a classe para ser um controller e ela vai responder por requesições.
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserCrudService userCrudService;

    @Autowired
    private UserAdicionarDocumentoService userAdicionarDocumentoService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userCrudService.userFindAllService());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userCrudService.userFindyByIdService(id));
    }
    @PostMapping("/criar-cliente")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserPostDto userPostDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userCrudService.userCreateService(userPostDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Long id,
            @RequestParam String codigoAcesso
    ) {
        this.userCrudService.userDeleteById(id, codigoAcesso);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }

    @PatchMapping("/add-doc")
    public ResponseEntity<?> addDoc(@RequestParam String email, @RequestBody @Valid DocPostDto docPostDto) {
        userAdicionarDocumentoService.adicionardoc(email, docPostDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("");
    }
}
