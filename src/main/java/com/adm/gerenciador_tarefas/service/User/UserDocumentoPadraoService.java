package com.adm.gerenciador_tarefas.service.User;

import com.adm.gerenciador_tarefas.dto.Documento.DocPostDto;
import com.adm.gerenciador_tarefas.exception.User.UserNaoExisteException;
import com.adm.gerenciador_tarefas.model.Documento;
import com.adm.gerenciador_tarefas.model.User;
import com.adm.gerenciador_tarefas.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDocumentoPadraoService implements UserDocumentoService {
    @Autowired
    UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void adicionardoc(String email, DocPostDto docPostDto) {
        Documento doc = modelMapper.map(docPostDto, Documento.class);
        User user = userRepository.findByEmail(email);
        user.getDocumentos().add(doc);
        userRepository.save(user);
    }

    @Override
    public Set<Documento> buscarTodosDoc(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getDocumentos();
        }
        throw new UserNaoExisteException();
    }
}
