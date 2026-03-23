package org.example.controllers;

import org.example.models.Planilha;
import org.example.models.ScoreComparacao;
import org.example.services.PlanilhaService;
import org.example.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("Cadastro de Scores")
    public ScoreComparacao save(@RequestBody ScoreComparacao scoreComparacao) {
        return scoreService.save(scoreComparacao);
    }

    @GetMapping("Listagem de Scores")
    public List<ScoreComparacao> findAll(){return scoreService.findAll();}
}