package nous2.mediatheque.dto;

import java.time.LocalDate;

public class CdDTO {

    private Long id;

    private String nom;

    private LocalDate dateSortie;

    private boolean favori;

    private boolean utilise;

    public CdDTO(Long id, String nom, LocalDate dateSortie, boolean favori,
	    boolean utilise) {
	setId(id);
	setNom(nom);
	setDateSortie(dateSortie);
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

    public LocalDate getDateSortie() {
	return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
	this.dateSortie = dateSortie;
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
