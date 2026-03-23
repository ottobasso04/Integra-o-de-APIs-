package org.example.controllers;

import org.example.models.Usuario;
import org.example.repositories.UsuarioRepository;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PastOrPresent;
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
}
