package com.adrar.exercice1.service;

import com.adrar.exercice1.exception.SaveLivreExistException;
import com.adrar.exercice1.model.Livre;
import com.adrar.exercice1.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public Iterable<Livre> findAllBooks() {
        if(livreRepository.count() == 0) {
            LocalDate localDate = LocalDate.of(1862, 3, 29);
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Livre livre = new Livre("Les Misérables", "Saga de Victor Hugo", date);
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
        for(Livre checkLivre : this.findAllBooks()) {
            if(checkLivre.getTitle().equals(livre.getTitle())
            && checkLivre.getDescription().equals(livre.getDescription())
            && checkLivre.getDatePublication().equals(livre.getDatePublication())) {
               throw new SaveLivreExistException(checkLivre.getId());
            }
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

    public boolean exists(Long id) {
        return livreRepository.existsById(id);
    }
}
