package com.adrar.exercice1.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable=false, length = 50)
    private String title;

    @Column(name="description", nullable=false, length = 255)
    private String description;

    @Column(name="date_publication", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    public Livre() {}

    public Livre(String title, String description, Date datePublication) {
        this.title = title;
        this.description = description;
        this.datePublication = datePublication;
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

    @Override
    public String toString() {
        return "Livre{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
