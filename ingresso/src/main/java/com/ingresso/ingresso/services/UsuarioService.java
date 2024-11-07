package com.ingresso.ingresso.services;

//import com.ingresso.ingresso.entities.UsuarioEntity;
//import com.ingresso.ingresso.entities.UsuarioRequest;
//import com.ingresso.ingresso.entities.UsuarioResponse;
import com.ingresso.ingresso.entities.UsuarioEntity;
import com.ingresso.ingresso.entities.UsuarioRequest;
import com.ingresso.ingresso.entities.UsuarioResponse;
import com.ingresso.ingresso.mapper.UsuarioMapper;
import com.ingresso.ingresso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.ingresso.ingresso.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioEntity> findAll() {
        return repository.findAll();
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.mapToEntity(usuario);

        UsuarioResponse usuarioResponse = UsuarioMapper.mapToResponse(usuarioEntity);
         repository.save(usuarioEntity);
         return usuarioResponse;
    }
}
