package org.example.controllers;

import org.example.models.ComparacaoPlanilha;
import org.example.services.ComparacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComparacaoController {

    @Autowired
    private ComparacaoService comparacaoService;

    @PostMapping("Cadastro de Comparações")
    private ComparacaoPlanilha save(@RequestBody ComparacaoPlanilha comparacaoPlanilha) {
        return comparacaoService.save(comparacaoPlanilha);
    }

    @GetMapping("Listagem de comparações")
    private List<ComparacaoPlanilha> getComparacaoPlanilha() {return comparacaoService.findAll();}
}
