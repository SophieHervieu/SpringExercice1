package com.adrar.exercice1.exception;

import com.adrar.exercice1.model.Livre;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException(Livre livre) {

      super("Le livre : " + livre.getTitle() + " existe déjà");
    }
}
