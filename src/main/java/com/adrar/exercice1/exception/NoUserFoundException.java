package com.adrar.exercice1.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException() {

      super("Aucun utilisateur trouvé.");
    }
}
