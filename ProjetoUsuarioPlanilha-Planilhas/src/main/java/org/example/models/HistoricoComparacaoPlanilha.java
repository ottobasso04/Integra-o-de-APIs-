package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;

@Document
public class HistoricoComparacaoPlanilha {

    @Id
    private String id;
    @NotEmpty
    private ComparacaoPlanilha comparacaoPlanilha;
    @DateTimeFormat
    private ComparacaoPlanilha data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ComparacaoPlanilha getComparacaoPlanilha() {
        return comparacaoPlanilha;
    }

    public void setComparacaoPlanilha(ComparacaoPlanilha comparacaoPlanilha) {
        this.comparacaoPlanilha = comparacaoPlanilha;
    }

    public ComparacaoPlanilha getData() {
        return data;
    }

    public void setData(ComparacaoPlanilha data) {
        this.data = data;
    }
}
