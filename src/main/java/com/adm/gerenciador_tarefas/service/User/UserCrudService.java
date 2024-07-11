package com.adm.gerenciador_tarefas.service.User;

import com.adm.gerenciador_tarefas.dto.User.UserPostDto;
import com.adm.gerenciador_tarefas.model.User;

import java.util.List;

public interface UserCrudService {
    User userCreateService(UserPostDto userDTO);
    void userDeleteById(Long id, String chaveAcesso);
    List<User> userFindAllService();
    User userFindyByIdService(Long id);
}
