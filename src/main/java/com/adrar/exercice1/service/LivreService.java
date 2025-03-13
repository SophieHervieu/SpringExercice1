package com.adrar.exercice1.service;

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

    public Optional<Livre> findById(Long id) {
        return Optional.of(livreRepository.findById(id).orElse(new Livre()));
    }

    public Livre addBook(Livre livre) {
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
}
