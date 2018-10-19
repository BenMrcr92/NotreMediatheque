package nous2.mediatheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nous2.mediatheque.entities.Cd;

public interface ICdJpaRepository extends JpaRepository<Cd, Long> {
    //
}
