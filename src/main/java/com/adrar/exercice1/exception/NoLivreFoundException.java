package com.adrar.exercice1.exception;

public class NoLivreFoundException extends RuntimeException {
    public NoLivreFoundException() {

      super("Aucun livre dans la base de données");
    }
}
