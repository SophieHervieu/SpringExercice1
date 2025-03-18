package com.adrar.exercice1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname", nullable = false, length = 50)
    @NotBlank(message="le prénom doit être renseigné")
    @Size(min = 2, message ="le prénom doit posséder au moins 2 caractères")
    private String firstname;

    @Column(name="lastname", nullable = false, length = 50)
    @NotBlank(message="le nom doit être renseigné")
    @Size(min = 2, message ="le nom doit posséder au moins 2 caractères")
    private String lastname;

    @Column(name="email", nullable = false, unique = true)
    @NotBlank(message="le mail doit être renseigné")
    @Email(message="le mail doit être valide")
    private String email;

    @Column(name="password", nullable = false)
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@!])(?=\\\\S+$).{8,20}$    " +
            "   ",
            message="le mot de passe doit contenir au moins un chiffre, une lettre, un caractère spécial et pas d'espace")
    private String password;

    public User() {}

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
