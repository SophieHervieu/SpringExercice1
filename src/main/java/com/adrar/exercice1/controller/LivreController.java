package com.adrar.exercice1.controller;

import com.adrar.exercice1.dto.LivreDto;
import com.adrar.exercice1.exception.LivreNotFoundException;
import com.adrar.exercice1.exception.NoLivreFoundException;
import com.adrar.exercice1.model.Livre;
import com.adrar.exercice1.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/books")
    public Iterable<Livre> getAllBooks() {
        if(livreService.countLivre() == 0) {
            throw new NoLivreFoundException();
        }
        return livreService.findAllBooks();
    }

    @GetMapping("/book/{id}")
    public Livre getBookById(@PathVariable Long id) {
        return livreService.findById(id).orElseThrow(
                () -> new LivreNotFoundException(id)
        );
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Livre addBook(@Valid @RequestBody Livre livre) {
        return livreService.addBook(livre);
    }

    @PutMapping("/book/{id}")
    public Livre updateBook(@RequestBody Livre livre, @PathVariable Long id) {
        return livreService.updateBook(id, livre);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable Long id) {
        if(!livreService.exists(id)){
            return "Le livre n'existe pas";
        }
        livreService.deleteBookById(id);
        return "Livre supprimé avec succès";
    }

    @GetMapping("/bookdto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivreDto getLivreDtoById(@PathVariable Long id) {
        return livreService.getLivreDtoById(id);
    }

    @GetMapping("/bookdto")
    @ResponseStatus(HttpStatus.OK)
    public List<LivreDto> getAllLivres() {
        return livreService.getAllLivres();
    }
}
