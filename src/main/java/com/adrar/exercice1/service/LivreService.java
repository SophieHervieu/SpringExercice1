package com.adrar.exercice1.service;

import com.adrar.exercice1.dto.LivreDto;
import com.adrar.exercice1.exception.SaveLivreExistException;
import com.adrar.exercice1.exception.UpdateLivreNotFoundException;
import com.adrar.exercice1.model.Genre;
import com.adrar.exercice1.model.Livre;
import com.adrar.exercice1.model.MaisonEdition;
import com.adrar.exercice1.repository.GenreRepository;
import com.adrar.exercice1.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private LivreDtoWrapper livreDtoWrapper;

    public Iterable<Livre> findAllBooks() {
        if(livreRepository.count() == 0) {
            LocalDate localDate = LocalDate.of(1862, 3, 29);
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Livre livre = new Livre();
        }
        return livreRepository.findAll();
    }

    public Long countLivre() {
        return livreRepository.count();
    }

    public Optional<Livre> findById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre addBook(Livre livre) {
        if(livreRepository.findByTitleAndDescription(livre.getTitle(), livre.getDescription()).isPresent()) {
           throw new SaveLivreExistException(livre);
        }
        return livreRepository.save(livre);
    }

    public Livre updateBook(Long id, Livre livre) {
        Optional<Livre> check = livreRepository.findById(id);
        if(check.isPresent()) {
            Livre updatedLivre = check.get();
            updatedLivre.setTitle(livre.getTitle());
            updatedLivre.setDescription(livre.getDescription());
            updatedLivre.setDatePublication(livre.getDatePublication());

            return livreRepository.save(updatedLivre);
        }
        return null;
    }

    public boolean deleteBookById(Long id) {
        if(livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addGenre(Genre genre) {
        this.genreRepository.save(genre);
    }

    public void removeGenre(Genre genre) {
        this.genreRepository.delete(genre);
    }

    public boolean exists(Long id) {
        return livreRepository.existsById(id);
    }

    public List<LivreDto> getAllLivres() {
        List<LivreDto> livres = new ArrayList<>();
        for(Livre livre : livreRepository.findAll()) {
            livres.add(livreDtoWrapper.livreDto(livre));
        }
        return livres;
    }

    public LivreDto getLivreDtoById(Long id) {
        if(!livreRepository.existsById(id)) {
            throw new UpdateLivreNotFoundException(id);
        }
        return livreDtoWrapper.livreDto(livreRepository.findById(id).get());
    }
}
