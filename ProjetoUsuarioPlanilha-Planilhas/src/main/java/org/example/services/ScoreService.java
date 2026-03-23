package org.example.services;

import org.example.models.ScoreComparacao;
import org.example.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public ScoreComparacao save(ScoreComparacao scoreComparacao){return scoreRepository.save(scoreComparacao);}
    public List<ScoreComparacao> findAll(){return scoreRepository.findAll();}
}
