package com.ingresso.ingresso.resources;

import com.ingresso.ingresso.entities.UsuarioEntity;
import com.ingresso.ingresso.entities.UsuarioRequest;
import com.ingresso.ingresso.entities.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ingresso.ingresso.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService service;
    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> findAll(){
        List<UsuarioEntity>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarCadrastro(@Valid @RequestBody UsuarioRequest usuario){
    try{
        UsuarioResponse criarCadastro = service.criarUsuario(usuario);
        return new ResponseEntity<>(criarCadastro, HttpStatus.CREATED);
    }catch (RuntimeException e){
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    }
}
