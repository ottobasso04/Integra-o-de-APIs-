package org.example.controllers;

import org.example.models.Usuario;
import org.example.repositories.UsuarioRepository;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("Cadastro de Usuário")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("Listagem de usuários")
    public List<Usuario> findAll(){return usuarioService.findAll();}

    @GetMapping("Buscar-usuarios-por-Id/{id}")
    public Usuario findById(@PathVariable String id){
        return usuarioService.findById(id);
    }

    // Importe a classe org.springframework.http.MediaType
    @PostMapping(value = "/importar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> importarPlanilha(@RequestParam("file") MultipartFile file) {

        // Chama o motor que criamos no Service
        usuarioService.importarUsuariosViaPlanilha(file);

        return ResponseEntity.ok("Planilha lida e usuários cadastrados com sucesso!");
    }
}
