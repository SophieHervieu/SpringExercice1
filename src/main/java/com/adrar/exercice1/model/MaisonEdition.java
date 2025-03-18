package com.adrar.exercice1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="maison_edition")
public class MaisonEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="libelle", nullable = false, length = 50)
    @NotBlank(message="le libellé de la maison d'édition ne peut pas être vide")
    @Size(min = 2, message="Le libellé de la maison d'édition doit contenir au minimum 2 caractères")
    private String libelle;

    @Column(name="description", length = 255)
    @NotNull(message="La description de la maison d'édition ne peut avoir une valeur nulle")
    @Size(min = 5, message="La description de la maison d'édition doit contenir au minimum 5 caractères")
    private String description;

    public MaisonEdition() {}
    public MaisonEdition(Integer id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MaisonEdition{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
