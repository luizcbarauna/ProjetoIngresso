package com.ingresso.ingresso.mapper;

import com.ingresso.ingresso.entities.UsuarioEntity;
import com.ingresso.ingresso.entities.UsuarioRequest;
import com.ingresso.ingresso.entities.UsuarioResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

}
