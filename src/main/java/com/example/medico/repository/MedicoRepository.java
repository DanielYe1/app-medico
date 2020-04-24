package com.example.medico.repository;

import com.example.medico.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
}
