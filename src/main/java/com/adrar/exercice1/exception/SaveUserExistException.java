package com.adrar.exercice1.exception;

import com.adrar.exercice1.model.User;

public class SaveUserExistException extends RuntimeException {
    public SaveUserExistException(User user) {

        super("L'utilisateur avec l'email " + user.getEmail() + " existe déjà.");
    }
}
