package com.adrar.exercice1.exception;

public class UpdateLivreNotFoundException extends RuntimeException {
    public UpdateLivreNotFoundException(Long id) {

        super("Le livre avec l'id : " + id + " n'existe pas");
    }
}
