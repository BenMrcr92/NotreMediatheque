package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.dto.LivreDTO;

@Repository
public class LivreRepository extends BaseRepository
	implements ILivreRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<LivreDTO> findAllAsDTO() {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.LivreDTO(l.id, l.nom, l.dateParution, l.favori, l.utilise)");
	queryBuilder.append(" from Livre l order by l.nom");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
