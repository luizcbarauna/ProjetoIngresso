package resources;

import entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UsuarioService;

import javax.swing.text.html.parser.Entity;
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
    public ResponseEntity<UsuarioEntity> criarCadrastro(UsuarioEntity usuario){
    try{
        UsuarioEntity criarCadastro = service.criarUsuario(usuario);
        return new ResponseEntity<>(criarCadastro, HttpStatus.CREATED);
    }catch (RuntimeException e){
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    }
}
