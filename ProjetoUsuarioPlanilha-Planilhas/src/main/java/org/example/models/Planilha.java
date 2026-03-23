package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
public class Planilha {

    @Id
    private String id;
    @NotEmpty
    private String nomePlanilha;
    @NotEmpty
    private double tamanhoArquivo;
    @NotEmpty
    private double qtdLinhas;
    @NotEmpty
    private double qtdColunas;
    @NotEmpty
    private Usuario usuarioCadastrado;
    @NotEmpty
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePlanilha() {
        return nomePlanilha;
    }

    public void setNomePlanilha(String nomePlanilha) {
        this.nomePlanilha = nomePlanilha;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public double getQtdLinhas() {
        return qtdLinhas;
    }

    public void setQtdLinhas(double qtdLinhas) {
        this.qtdLinhas = qtdLinhas;
    }

    public double getQtdColunas() {
        return qtdColunas;
    }

    public void setQtdColunas(double qtdColunas) {
        this.qtdColunas = qtdColunas;
    }

    public Usuario getUsuarioCadastrado() {
        return usuarioCadastrado;
    }

    public void setUsuarioCadastrado(Usuario usuarioCadastrado) {
        this.usuarioCadastrado = usuarioCadastrado;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
