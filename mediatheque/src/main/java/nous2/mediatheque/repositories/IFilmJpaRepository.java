package nous2.mediatheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nous2.mediatheque.entities.Film;

public interface IFilmJpaRepository extends JpaRepository<Film, Long> {
    //
}
