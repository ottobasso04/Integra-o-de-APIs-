package org.example.controllers;

import org.example.models.Endereco;
import org.example.repositories.EnderecoRepository;
import org.example.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("Cadastro de endereço")
    public Endereco save(@RequestBody Endereco endereco) {
        return enderecoService.save(endereco);
    }

    @GetMapping("Listagem de endereços")
    public List<Endereco> findAll(){return enderecoService.findAll();}
}
