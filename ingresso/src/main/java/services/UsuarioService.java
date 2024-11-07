package services;

import entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioEntity> findAll() {
        return repository.findAll();
    }

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        return repository.save(usuario);
    }
}
