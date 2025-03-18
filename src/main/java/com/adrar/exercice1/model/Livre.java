package com.adrar.exercice1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre", nullable=false, length = 50)
    @NotBlank(message="Le titre du livre ne peut pas être vide")
    @Size(max = 3, message ="Le titre du livre doit faire au minimum 3 caractères")
    private String title;

    @Column(name="description", nullable=false, length = 255)
    @NotBlank(message="La description du livre ne peut pas être vide")
    @Size(max = 5, message ="La description du livre doit faire au minimum 5 caractères")
    private String description;

    @Column(name="date_publication", nullable=false)
    @Temporal(TemporalType.DATE)
    @PastOrPresent()
    private Date datePublication;

    @Min(value = 1800, message = "L'année doit être après 1800")
    @Max(value = 2025, message = "L'année doit être avant 2025")
    public int getYear() {
        return datePublication != null ? datePublication.getYear() : 0;
    }

    @Column(name="auteur", nullable = true, length = 50)
    @NotNull(message="L'auteur du livre ne peut pas avoir une valeur nulle")
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;

    @ManyToOne
    @JoinColumn(name="maison_edition_id")
    private MaisonEdition maisonEdition;

    @ManyToMany
    @JoinTable(name="livre_genre",
    joinColumns = @JoinColumn(name="livre_id"),
    inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genres;

    public Livre() {
        this.genres = new ArrayList<>();
    }

    public Livre(String title, String description, Date datePublication, String auteur, MaisonEdition maisonEdition) {
        this.title = title;
        this.description = description;
        this.datePublication = datePublication;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
        this.genres = new ArrayList<>();
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Genre genres) {
        this.genres.add(genres);
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", auteur='" + auteur + '\'' +
                ", user=" + user +
                ", maisonEdition=" + maisonEdition.toString() +
                ", genres=" + genres +
                '}';
    }
}
