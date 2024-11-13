package com.ingresso.ingresso.resources;

import com.ingresso.ingresso.entities.UsuarioEntity;
import com.ingresso.ingresso.entities.UsuarioListResponse;
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
    public ResponseEntity<List<UsuarioListResponse>> findAll() {
        List<UsuarioListResponse> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable String id) throws Exception {
        UsuarioResponse usuarioResponse = service.findById(id);
        return ResponseEntity.ok().body(usuarioResponse);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarCadrastro(@Valid @RequestBody UsuarioRequest usuario) {
        try {
            UsuarioResponse criarCadastro = service.criarUsuario(usuario);
            return new ResponseEntity<>(criarCadastro, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>deleteUsuario(@PathVariable String id) throws Exception {
       service.deleteUsuario(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
