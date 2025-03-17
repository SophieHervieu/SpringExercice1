package com.adrar.exercice1.controller;


import com.adrar.exercice1.repository.MaisonEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaisonEditionController {

    @Autowired
    private MaisonEditionRepository maisonEditionRepository;


}
