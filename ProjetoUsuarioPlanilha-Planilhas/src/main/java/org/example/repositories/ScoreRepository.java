package org.example.repositories;

import org.example.models.ScoreComparacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends MongoRepository <ScoreComparacao, String> {
}
