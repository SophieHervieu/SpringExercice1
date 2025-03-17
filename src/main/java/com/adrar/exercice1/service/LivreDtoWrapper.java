package com.adrar.exercice1.service;

import com.adrar.exercice1.dto.LivreDto;
import com.adrar.exercice1.model.Genre;
import com.adrar.exercice1.model.Livre;
import com.adrar.exercice1.model.MaisonEdition;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreDtoWrapper {

    public LivreDto livreDto(Livre livre) {
        return new LivreDto(
                livre.getId(),
                livre.getTitle(),
                livre.getDescription(),
                new Date(2025-1-1).toString(),
                livre.getMaisonEdition().getLibelle(),
                livre.getGenres().stream().map(Genre::getName).collect(Collectors.toList()
                ));
    }

    public List<LivreDto> livreDtoList(List<Livre> livres) {
        return livres.stream().map(this::livreDto).collect(Collectors.toList());
    }
}
