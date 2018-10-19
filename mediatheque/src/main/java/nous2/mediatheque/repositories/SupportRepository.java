package nous2.mediatheque.repositories;

import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.SupportDTO;

@Repository
public class SupportRepository extends BaseRepository
	implements ISupportRepository {

    @SuppressWarnings("unchecked")
    @Override
    public Set<SupportDTO> findAllAsDTO(AppLanguage lang) {
	StringBuilder queryBuilder = new StringBuilder(
		"select nous2.mediatheque.dto.SupportDTO(c.id, c.");
	String nameCol = "typeFr";
	if (lang.isEnglish()) {
	    nameCol = "typeEn";
	}
	queryBuilder.append(nameCol);
	queryBuilder.append(") from Support c order by c.code");
	Query query = em.createQuery(queryBuilder.toString());
	return (Set<SupportDTO>) query.getResultList();
    }
}
