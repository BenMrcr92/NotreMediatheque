package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.FilmDTO;

@Repository
public class FilmRepository extends BaseRepository implements IFilmRepository {

    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    public List<FilmDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.FilmDTO(f.id, f.nom, f.dateSortie, f.favori, f.utilise, f.dvd, f.blueRay, f.numerique)");
	queryBuilder.append(" from Film f");
	queryBuilder.append(" order by f.nom, f.dateSortie");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}