package org.example.controllers;

import org.example.models.Planilha;
import org.example.services.PlanilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanilhaController {

    @Autowired
    private PlanilhaService planilhaService;

    @PostMapping("Cadastro de Planilha")
    public Planilha save(@RequestBody Planilha planilha){
        return planilhaService.save(planilha);
    }

    @GetMapping("Listagem de Planilha")
    public List<Planilha> findAll(){return planilhaService.findAll();}
}
