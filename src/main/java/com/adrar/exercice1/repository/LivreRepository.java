package com.adrar.exercice1.repository;

import com.adrar.exercice1.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Long> {
    Optional<Livre> findByTitleAndDescription(String title, String description);
}
