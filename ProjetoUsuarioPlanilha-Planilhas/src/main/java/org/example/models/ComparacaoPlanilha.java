package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Document
public class ComparacaoPlanilha {

    @Id
    private String id;
    @NotEmpty
    private Planilha planilhaInicial;
    @NotEmpty
    private Planilha planilhaComparacao;
    @NotEmpty
    private String descricao;
    @NotEmpty
    private Boolean status;
    @NotEmpty
    private ScoreComparacao scoreComparacao;
    @DateTimeFormat
    private LocalDate data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Planilha getPlanilhaInicial() {
        return planilhaInicial;
    }

    public void setPlanilhaInicial(Planilha planilhaInicial) {
        this.planilhaInicial = planilhaInicial;
    }

    public Planilha getPlanilhaComparacao() {
        return planilhaComparacao;
    }

    public void setPlanilhaComparacao(Planilha planilhaComparacao) {
        this.planilhaComparacao = planilhaComparacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ScoreComparacao getScoreComparacao() {
        return scoreComparacao;
    }

    public void setScoreComparacao(ScoreComparacao scoreComparacao) {
        this.scoreComparacao = scoreComparacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
