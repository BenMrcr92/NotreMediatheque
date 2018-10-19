package nous2.mediatheque.dto;

import java.time.LocalDate;

public class LivreDTO {

    private Long id;

    private String nom;

    private LocalDate dateParution;

    private boolean favori;

    private boolean utilise;

    public LivreDTO(Long id, String nom, LocalDate dateParution, boolean favori,
	    boolean utilise) {
	setId(id);
	setNom(nom);
	setDateParution(dateParution);
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

    public LocalDate getDateParution() {
	return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
	this.dateParution = dateParution;
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
