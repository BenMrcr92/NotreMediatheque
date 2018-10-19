package nous2.mediatheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nous2.mediatheque.entities.Jeu;

public interface IJeuJpaRepository extends JpaRepository<Jeu, Long> {
    //
}
