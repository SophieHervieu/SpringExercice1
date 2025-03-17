package com.adrar.exercice1.repository;


import com.adrar.exercice1.model.MaisonEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaisonEditionRepository extends CrudRepository<MaisonEdition, Integer> {
    Optional<MaisonEdition> findByLibelleAndDescription(String libelle, String description);
}
