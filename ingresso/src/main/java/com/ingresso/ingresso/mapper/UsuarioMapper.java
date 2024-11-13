package com.ingresso.ingresso.mapper;

import com.ingresso.ingresso.entities.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UsuarioMapper {
    public static UsuarioEntity mapToEntity(UsuarioRequest usuarioRequest){
        if(usuarioRequest ==null){
            return null;
        }
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(UUID.randomUUID().toString());
        usuarioEntity.setCpf(usuarioRequest.getCpf());
        usuarioEntity.setEmail(usuarioRequest.getEmail());
        usuarioEntity.setNomeCompleto(usuarioRequest.getNomeCompleto());
        usuarioEntity.setSenha(usuarioRequest.getSenha());
        usuarioEntity.setApelido(usuarioRequest.getApelido());
        usuarioEntity.setDataNascimento(usuarioRequest.getDataNascimento());
        usuarioEntity.setCelular(usuarioRequest.getCelular());
        usuarioEntity.setGenero(GeneroMapper.getGenero(usuarioRequest.getGenero()));
        usuarioEntity.setDataCadastro(LocalDateTime.now());
        usuarioEntity.setEndereco(usuarioRequest.getEndereco());
        return usuarioEntity;
    }

    public static UsuarioResponse mapToResponse(UsuarioEntity usuarioEntity){
      if (usuarioEntity==null) {
          return null;
      }
      UsuarioResponse usuarioResponse = new UsuarioResponse();
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        usuarioResponse.setId(usuarioEntity.getId());
        usuarioResponse.setCpf(usuarioEntity.getCpf());
        usuarioResponse.setEmail(usuarioEntity.getEmail());
        usuarioResponse.setNomeCompleto(usuarioEntity.getNomeCompleto());
        usuarioResponse.setApelido(usuarioEntity.getApelido());
        usuarioResponse.setDataNascimento(usuarioEntity.getDataNascimento());
        usuarioResponse.setCelular(usuarioEntity.getCelular());
        usuarioResponse.setGenero(GeneroMapper.getCode(usuarioEntity.getGenero()));
        usuarioResponse.setDataCadastro(ZonedDateTime.of(usuarioEntity.getDataCadastro(), ZoneId.systemDefault()).format(dfm));
        usuarioResponse.setEndereco(usuarioEntity.getEndereco());
        return usuarioResponse;
    }

    public static List<UsuarioListResponse> mapToList(List<UsuarioEntity> usuario) {
        List <UsuarioListResponse> usuarioListResponse = new ArrayList<>();
        for( UsuarioEntity usuarioEntity : usuario ) {
            UsuarioListResponse response = new UsuarioListResponse();

        response.setId(usuarioEntity.getId());
        response.setCpf(usuarioEntity.getCpf());
        response.setEmail(usuarioEntity.getEmail());
        response.setNomeCompleto(usuarioEntity.getNomeCompleto());
        usuarioListResponse.add(response);

    }
        return usuarioListResponse;
}
    public static UsuarioUptadeResponse mapToResponseUpdate(UsuarioEntity usuarioEntity){
        if (usuarioEntity==null) {
            return null;
        }
        UsuarioUptadeResponse usuarioResponse = new UsuarioUptadeResponse();
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        usuarioResponse.setId(usuarioEntity.getId());
        usuarioResponse.setCpf(usuarioEntity.getCpf());
        usuarioResponse.setEmail(usuarioEntity.getEmail());
        usuarioResponse.setSenha(usuarioEntity.getSenha());
        usuarioResponse.setNomeCompleto(usuarioEntity.getNomeCompleto());
        usuarioResponse.setApelido(usuarioEntity.getApelido());
        usuarioResponse.setDataNascimento(usuarioEntity.getDataNascimento());
        usuarioResponse.setCelular(usuarioEntity.getCelular());
        usuarioResponse.setGenero(GeneroMapper.getCode(usuarioEntity.getGenero()));
        usuarioResponse.setEndereco(usuarioEntity.getEndereco());
        usuarioResponse.setDataCadastro(ZonedDateTime.of(usuarioEntity.getDataCadastro(), ZoneId.systemDefault()).format(dfm));
        usuarioResponse.setDataAtualizacao(ZonedDateTime.of(usuarioEntity.getDataAtualizacao(), ZoneId.systemDefault()).format(dfm));
        return usuarioResponse;
    }
}