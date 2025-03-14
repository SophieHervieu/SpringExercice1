package com.adrar.exercice1.controller;

import com.adrar.exercice1.exception.LivreNotFoundException;
import com.adrar.exercice1.exception.NoLivreFoundException;
import com.adrar.exercice1.exception.SaveLivreExistException;
import com.adrar.exercice1.exception.UpdateLivreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> livreNotFound(LivreNotFoundException livreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", livreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoLivreFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> noLivre(NoLivreFoundException noLivreFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", noLivreFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(UpdateLivreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> updateLivre(UpdateLivreNotFoundException updateLivreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", updateLivreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveLivreExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> saveLivre(SaveLivreExistException saveLivreExist) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", saveLivreExist.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }
}
