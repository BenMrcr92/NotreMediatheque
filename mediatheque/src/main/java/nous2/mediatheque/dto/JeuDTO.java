package nous2.mediatheque.dto;

import java.time.LocalDate;

public class JeuDTO {

    private Long id;

    private String nom;

    private LocalDate dateEdition;

    private boolean favori;

    private boolean utilise;

    public JeuDTO(Long id, String nom, LocalDate dateEdition, boolean favori,
	    boolean utilise) {
	setId(id);
	setNom(nom);
	setDateEdition(dateEdition);
	setFavori(favori);
	setUtilise(utilise);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public LocalDate getDateEdition() {
	return dateEdition;
    }

    public void setDateEdition(LocalDate dateEdition) {
	this.dateEdition = dateEdition;
    }

    public boolean isFavori() {
	return favori;
    }

    public void setFavori(boolean favori) {
	this.favori = favori;
    }

    public boolean isUtilise() {
	return utilise;
    }

    public void setUtilise(boolean utilise) {
	this.utilise = utilise;
    }
}
