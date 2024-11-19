package com.ingresso.ingresso.resources;

import com.ingresso.ingresso.entities.*;
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
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) throws Exception {
        service.deleteUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<UsuarioUpdateResponse> updateUsuario(@RequestBody UsuarioUpdateRequest usuario, @PathVariable String id) {
        try {
            UsuarioUpdateResponse uptadeUsuario = service.uptadeUsuario(usuario, id);
            return new ResponseEntity<>(uptadeUsuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/senhas/{id}")
    public ResponseEntity<String> recuperarSenha(@PathVariable String id) throws Exception {
        UsuarioResponse usuarioResponse = service.findByIdAlterarSenha(id);
        return ResponseEntity.ok().body(usuarioResponse.getCodigoDeSeguranca());
}
    @PostMapping(value = "/{id}/senhas")
    public ResponseEntity alterarSenha(@RequestBody UpdateSenhaRequest novaSenha, @PathVariable String id){
        try {

            service.uptadeSenha(novaSenha, id);
            return new ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/{id}/senhas")
    public ResponseEntity<UsuarioEntity> alteracaoSenha(@RequestBody UpdateSenhaRequest novaSenha, @PathVariable String id){
       try {
        service.uptadeSenhaAlteracao(novaSenha, id);
        return new ResponseEntity<>( HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    }

}


