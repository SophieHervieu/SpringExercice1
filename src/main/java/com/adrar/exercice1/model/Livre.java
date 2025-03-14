package com.adrar.exercice1.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre", nullable=false, length = 50)
    private String title;

    @Column(name="description", nullable=false, length = 255)
    private String description;

    @Column(name="date_publication", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name="genres", nullable = true, length = 50)
    private String genres;

    @Column(name="auteur", nullable = true, length = 50)
    private String auteur;

    @Column(name="maison_edition", nullable = true, length = 50)
    private String maisonEdition;

    public Livre() {}

    public Livre(String title, String description, Date datePublication, String genres, String auteur, String maisonEdition) {
        this.title = title;
        this.description = description;
        this.datePublication = datePublication;
        this.genres = genres;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", genres='" + genres + '\'' +
                ", auteur='" + auteur + '\'' +
                ", maisonEdition='" + maisonEdition + '\'' +
                '}';
    }
}
