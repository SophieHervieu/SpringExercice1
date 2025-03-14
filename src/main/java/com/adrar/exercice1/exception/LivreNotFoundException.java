package com.adrar.exercice1.exception;

public class LivreNotFoundException extends RuntimeException {
    public LivreNotFoundException(Long id) {
        super("Le livre avec l'id : " + id + " n'existe pas");
    }
}
