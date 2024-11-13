package com.ingresso.ingresso.services;

//import com.ingresso.ingresso.entities.UsuarioEntity;
//import com.ingresso.ingresso.entities.UsuarioRequest;
//import com.ingresso.ingresso.entities.UsuarioResponse;

import com.ingresso.ingresso.entities.UsuarioEntity;
import com.ingresso.ingresso.entities.UsuarioListResponse;
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

    public List<UsuarioListResponse> findAll() {
        List<UsuarioEntity> usuario = repository.findAll();
        List<UsuarioListResponse> listResponses = UsuarioMapper.mapToList(usuario);

        return listResponses;
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.mapToEntity(usuario);
        UsuarioResponse usuarioResponse = UsuarioMapper.mapToResponse(usuarioEntity);
        repository.save(usuarioEntity);
        return usuarioResponse;
    }

    public UsuarioResponse findById(String id)throws Exception {

        UsuarioEntity usuario = repository.findById(id).orElse(null);
        if (usuario == null) {
            throw new Exception();
        }
        UsuarioResponse usuarioResponse = UsuarioMapper.mapToResponse(usuario);
        return usuarioResponse;
    }

    public void deleteUsuario(String id) throws Exception {
        UsuarioEntity usuario = repository.findById(id).orElse(null);
        if (usuario == null) {
            throw new Exception();
        }
        repository.delete(usuario);
    }
}
