package org.example.controllers;

import org.example.models.HistoricoComparacaoPlanilha;
import org.example.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @PostMapping("Cadastro de históricos de comparação")
    public HistoricoComparacaoPlanilha save(@RequestBody HistoricoComparacaoPlanilha historicoComparacaoPlanilha) {
        return historicoService.save(historicoComparacaoPlanilha);
    }

    @GetMapping("Listar históricos de comparação")
    public List<HistoricoComparacaoPlanilha> findAll() {return historicoService.findAll();}
}
