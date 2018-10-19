package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.FilmDTO;

@Repository
public class FilmRepository extends BaseRepository implements IFilmRepository {

    @Override
    @SuppressWarnings({ "unchecked", "unused" })
    public List<FilmDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.FilmDTO(f.id, f.nom, f.dateSortie, f.favori, f.utilise");
	// String typeSupportCol = "typeFr";
	// if (lang.isEnglish()) {
	// typeSupportCol = "typeEn";
	// }
	// queryBuilder.append(, s.typeSupportCol);
	queryBuilder.append(") from Film f");
	// queryBuilder.append(" inner join Support s");
	queryBuilder.append(" order by f.nom, f.dateSortie");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}