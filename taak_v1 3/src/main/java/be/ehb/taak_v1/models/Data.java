package be.ehb.taak_v1.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "data_id")
    private int id;

    @NotBlank(message = "Naam van het product mag niet leeg zijn")
    @Size(min = 3, max = 200, message = "Naam mag min. 3 karakters lang zijn en max. 20 karakters")
    private String naam;
    @NotBlank(message = "Omschrijving van het product mag niet leeg zijn")
    @Size(max = 1000, message = "Omschrijving mag max. 1OOO karakters lang zijn")
    private String omschrijving;
    @NotBlank(message = "Username mag niet leeg zijn")
    @Size(min = 5, message = "Username mag min. 5 karakters lang zijn")
    private String username;
    @NotBlank(message = "Email mag niet leeg zijn")
    @Email(message = "Niet correct")
    private String email;
    @DecimalMin(value = "0.0", message = "Juiste prijs formaat gebruiken")
    private double vraagprijs;
    private String categorie;
    private String foto_url;

    public Data() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVraagprijs() {
        return vraagprijs;
    }

    public void setVraagprijs(double vraagprijs) {
        this.vraagprijs = vraagprijs;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorieen) {
        this.categorie = categorieen;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }
}
