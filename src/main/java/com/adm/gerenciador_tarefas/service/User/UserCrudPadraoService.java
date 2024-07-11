package com.adm.gerenciador_tarefas.service.User;

import com.adm.gerenciador_tarefas.dto.User.UserPostDto;
import com.adm.gerenciador_tarefas.exception.User.UserNaoExisteException;
import com.adm.gerenciador_tarefas.exception.Validacao.ChaveDeAcessoInvalidaException;
import com.adm.gerenciador_tarefas.exception.Validacao.CodigoAcessoInvalidoException;
import com.adm.gerenciador_tarefas.model.User;
import com.adm.gerenciador_tarefas.repository.UserRepository;
import com.adm.gerenciador_tarefas.service.validation.ValidaChaveAcessoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCrudPadraoService implements UserCrudService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidaChaveAcessoService validaChaveAcessoService;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public User userCreateService(UserPostDto userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        String respostaValida = validaChaveAcessoService.validaChave(user.getChaveDeAcesso());
        if (!respostaValida.equals("Válida")) {
            throw new ChaveDeAcessoInvalidaException(respostaValida);
        }
        return userRepository.save(user);
    }

    @Override
    public void userDeleteById(Long id, String chaveAcesso) {
        User user = userRepository.findById(id).orElseThrow(UserNaoExisteException::new);
        if (!user.getChaveDeAcesso().equals(chaveAcesso)) {
            throw new CodigoAcessoInvalidoException();
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> userFindAllService() {
        return userRepository.findAll();
    }

    @Override
    public User userFindyByIdService(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNaoExisteException::new);
        return user;
    }
}
