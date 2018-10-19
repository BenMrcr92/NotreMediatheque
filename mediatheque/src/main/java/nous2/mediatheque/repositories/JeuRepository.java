package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.dto.JeuDTO;

@Repository
public class JeuRepository extends BaseRepository implements IJeuRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<JeuDTO> findAllAsDTO() {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.JeuDTO(j.id, j.nom, j.dateEdition, j.favori, j.utilise)");
	queryBuilder.append(" from Jeu j order by j.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
