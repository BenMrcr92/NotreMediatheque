package nous2.mediatheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nous2.mediatheque.entities.Support;

public interface ISupportJpaRepository extends JpaRepository<Support, Long> {

    public Support findByCode(String code);
}
