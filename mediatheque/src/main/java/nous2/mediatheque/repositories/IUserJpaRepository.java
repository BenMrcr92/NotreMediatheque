package nous2.mediatheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nous2.mediatheque.entities.User;

public interface IUserJpaRepository extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPseudoIgnoreCase(String pseudo);

    boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

    boolean existsByPseudoIgnoreCaseAndIdNot(String pseudo, Long id);

    public User findByEmail(String username);

    public User findByPseudo(String username);
}
