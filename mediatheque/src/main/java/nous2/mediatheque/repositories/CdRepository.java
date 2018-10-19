package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.dto.CdDTO;

@Repository
public class CdRepository extends BaseRepository implements ICdRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<CdDTO> findAllAsDTO() {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.CdDTO(c.id, c.nom, c.dateSortie, c.favori, c.utilise)");
	queryBuilder.append(" from Cd c order by c.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
