package nous2.mediatheque.test;

import nous2.mediatheque.entities.Film;

public class FilmTest {

    public static void main(String[] args) {
	System.out.println("création film...");
	Film film = new Film();
	film.setNom("youpi");
	System.out.println("nom : " + film.getNom());
	film.setDescription("film test");
	System.out.println("desc : " + film.getDescription());
	film.setFavori(true);
	System.out.println("favori : " + film.getFavori());
	film.setUtilise(true);
	System.out.println("regardé : " + film.getUtilise());
	Film film1 = new Film();
	film1.setNom("Le Seigneur des Anneaux");
	film1.setDescription("un super film �pique");
	film1.setFavori(true);
	film1.setUtilise(true);
	System.out.println("film créé");
    }
}
