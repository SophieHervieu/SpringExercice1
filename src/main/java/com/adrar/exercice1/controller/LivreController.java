package com.adrar.exercice1.controller;

import com.adrar.exercice1.model.Livre;
import com.adrar.exercice1.repository.LivreRepository;
import com.adrar.exercice1.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/books")
    public Iterable<Livre> getAllBooks() {
        return livreService.findAllBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Livre> getBookById(@PathVariable Long id) {
        return livreService.findById(id);
    }

    @PostMapping("/book")
    public Livre addBook(@RequestBody Livre livre) {
        return livreService.addBook(livre);
    }

    @PutMapping("/book/{id}")
    public Livre updateBook(@RequestBody Livre livre, @PathVariable Long id) {
        return livreService.updateBook(id, livre);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        livreService.deleteBookById(id);
    }
}
