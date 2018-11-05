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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (nom == null ? 0 : nom.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Element other = (Element) obj;
	if (nom == null) {
	    if (other.nom != null) {
		return false;
	    }
	} else if (!nom.equals(other.nom)) {
	    return false;
	}
	return true;
    }
}
