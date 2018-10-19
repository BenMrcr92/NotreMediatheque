package nous2.mediatheque.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
abstract class Element {

    @NotBlank(message = "{error.commons.required}")
    @Column(length = 50, nullable = false)
    protected String nom;

    @Column(length = 500)
    protected String description;

    @Column(nullable = false)
    protected boolean favori = false;

    @Column(nullable = false)
    protected boolean utilise = false;

    public Element() {
	//
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public boolean getFavori() {
	return favori;
    }

    public void setFavori(boolean favori) {
	this.favori = favori;
    }

    public boolean getUtilise() {
	return utilise;
    }

    public void setUtilise(boolean utilise) {
	this.utilise = utilise;
    }
}
