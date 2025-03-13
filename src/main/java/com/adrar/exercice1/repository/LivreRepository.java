package com.adrar.exercice1.repository;

import com.adrar.exercice1.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Long> {
}
