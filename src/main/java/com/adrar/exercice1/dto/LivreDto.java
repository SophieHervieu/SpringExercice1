package com.adrar.exercice1.dto;

import com.adrar.exercice1.model.Genre;
import com.adrar.exercice1.model.MaisonEdition;

import java.util.List;

public record LivreDto(
        Long id,
        String titre,
        String description,
        String date,
        String libelle,
        List<String> genres) {
}
