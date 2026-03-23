package org.example.repositories;

import org.example.models.HistoricoComparacaoPlanilha;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends MongoRepository <HistoricoComparacaoPlanilha, String> {
}
