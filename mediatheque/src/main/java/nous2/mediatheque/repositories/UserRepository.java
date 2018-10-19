package nous2.mediatheque.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import nous2.mediatheque.dto.UserDTO;

@Repository
public class UserRepository extends BaseRepository implements IUserRepository {

    @SuppressWarnings({ "unchecked" })
    @Override
    public List<UserDTO> findAllAsDTO() {
	StringBuilder queryBuilder = new StringBuilder(
		"select new nous2.mediatheque.dto.UserDTO(u.id, u.pseudo, u.email, u.lastname, u.firstname)");
	queryBuilder.append(" from User u");
	queryBuilder.append(" order by u.pseudo, u.email");
	Query query = em.createQuery(queryBuilder.toString());
	return query.getResultList();
    }
}
