package com.ingresso.ingresso.services;

//import com.ingresso.ingresso.entities.UsuarioEntity;
//import com.ingresso.ingresso.entities.UsuarioRequest;
//import com.ingresso.ingresso.entities.UsuarioResponse;

import com.ingresso.ingresso.entities.*;
import com.ingresso.ingresso.mapper.GeneroMapper;
import com.ingresso.ingresso.mapper.UsuarioMapper;
import com.ingresso.ingresso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.ingresso.ingresso.repositories.UsuarioRepository;

import java.time.LocalDateTime;
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

    public UsuarioResponse findById(String id) throws Exception {

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

    public UsuarioUptadeResponse uptadeUsuario(UsuarioUpdateRequest usuario, String id) throws Exception {
        UsuarioEntity usuarioExistente = repository.findById(id).orElse(null);
        if (usuario == null) {
            throw new Exception();
        }
        if (usuario.getCpf() != null) {
            usuarioExistente.setCpf(usuario.getCpf());
        }
        if (usuario.getEmail() != null) {
            usuarioExistente.setEmail(usuario.getEmail());
        }
        if (usuario.getNomeCompleto() != null) {
            usuarioExistente.setNomeCompleto(usuario.getNomeCompleto());
        }
        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha((usuario.getSenha()));
        }
        if (usuario.getApelido() != null) {
            usuarioExistente.setApelido(usuario.getApelido());
        }
        if (usuario.getDataNascimento() != null) {
            usuarioExistente.setDataNascimento(usuario.getDataNascimento());
        }
        if (usuario.getCelular() != null) {
            usuarioExistente.setCelular(usuario.getCelular());
        }
        if (usuario.getGenero() != null) {
            usuarioExistente.setGenero(GeneroMapper.getGenero(usuario.getGenero()));
        }
        if (usuario.getEndereco() != null) {
            usuarioExistente.setEndereco(usuario.getEndereco());
        }
        usuarioExistente.setDataAtualizacao(LocalDateTime.now());
        UsuarioUptadeResponse usuarioAtualizado = UsuarioMapper.mapToResponseUpdate(usuarioExistente);
        repository.save(usuarioExistente);
        return usuarioAtualizado;
    }
}
