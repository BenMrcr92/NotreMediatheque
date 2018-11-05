package nous2.mediatheque.dto;

import java.time.LocalDate;

public class FilmDTO {

    private Long id;

    private String nom;

    private LocalDate dateSortie;

    private boolean favori;

    private boolean utilise;

    private boolean dvd;

    private boolean blueRay;

    private boolean numerique;

    public FilmDTO(Long id, String nom, LocalDate dateSortie, boolean favori,
	    boolean utilise, boolean dvd, boolean blueRay, boolean numerique) {
	setId(id);
	setNom(nom);
	setDateSortie(dateSortie);
	setFavori(favori);
	setUtilise(utilise);
	setDvd(dvd);
	setBlueRay(blueRay);
	setNumerique(numerique);
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

    public boolean isDvd() {
	return dvd;
    }

    public void setDvd(boolean dvd) {
	this.dvd = dvd;
    }

    public boolean isBlueRay() {
	return blueRay;
    }

    public void setBlueRay(boolean blueRay) {
	this.blueRay = blueRay;
    }

    public boolean isNumerique() {
	return numerique;
    }

    public void setNumerique(boolean numerique) {
	this.numerique = numerique;
    }
}
