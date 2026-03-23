package org.example.services;

import org.example.models.ComparacaoPlanilha;
import org.example.models.HistoricoComparacaoPlanilha;
import org.example.repositories.ComparacaoRepository;
import org.example.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    @Autowired
    private ComparacaoRepository comparacaoRepository;

    public HistoricoComparacaoPlanilha save(HistoricoComparacaoPlanilha historicoComparacaoPlanilha) {

        String idComparacao = historicoComparacaoPlanilha.getComparacaoPlanilha().getId();
        ComparacaoPlanilha comparacaoReal = comparacaoRepository.findById(idComparacao)
                .orElseThrow(() -> new RuntimeException("Comparação não encontrada."));

        ComparacaoPlanilha objetoParaData = new ComparacaoPlanilha();
        objetoParaData.setData(comparacaoReal.getData());
        historicoComparacaoPlanilha.setData(objetoParaData);
        historicoComparacaoPlanilha.setComparacaoPlanilha(comparacaoReal);

        return historicoRepository.save(historicoComparacaoPlanilha);
    }
    public List<HistoricoComparacaoPlanilha> findAll() {return historicoRepository.findAll();}
}
