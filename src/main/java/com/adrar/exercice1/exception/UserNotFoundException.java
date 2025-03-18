package com.adrar.exercice1.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {

      super("L'utilisateur avec l'id : " + id + " n'existe pas.");
    }
}
