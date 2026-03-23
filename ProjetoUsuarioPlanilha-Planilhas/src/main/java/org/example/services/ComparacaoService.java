package org.example.services;

import org.example.models.ComparacaoPlanilha;
import org.example.models.Planilha;
import org.example.models.ScoreComparacao;
import org.example.repositories.ComparacaoRepository;
import org.example.repositories.PlanilhaRepository;
import org.example.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComparacaoService {

    @Autowired
    private ComparacaoRepository comparacaoRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlanilhaRepository planilhaRepository;

    public ComparacaoPlanilha save(ComparacaoPlanilha comparacaoPlanilha) {

        String idPlanilhaInicial = comparacaoPlanilha.getPlanilhaInicial().getId();
        Planilha planilhaInicial = planilhaRepository.findById(idPlanilhaInicial)
                .orElseThrow(() -> new RuntimeException("Planilha não encontrada"));

        String idPlanilhaComparacao = comparacaoPlanilha.getPlanilhaComparacao().getId();
        Planilha planilhaComparacao = planilhaRepository.findById(idPlanilhaComparacao)
                .orElseThrow(() -> new RuntimeException("Planilha não encontrada"));

        String idScoreComparacao = comparacaoPlanilha.getScoreComparacao().getId();
        ScoreComparacao scoreComparacao = scoreRepository.findById(idScoreComparacao)
                .orElseThrow(() -> new RuntimeException("Score não encontrado"));

        comparacaoPlanilha.setPlanilhaInicial(planilhaInicial);
        comparacaoPlanilha.setPlanilhaComparacao(planilhaComparacao);
        comparacaoPlanilha.setScoreComparacao(scoreComparacao);

        return comparacaoRepository.save(comparacaoPlanilha);
    }
    public List<ComparacaoPlanilha> findAll() {return comparacaoRepository.findAll();}
}
