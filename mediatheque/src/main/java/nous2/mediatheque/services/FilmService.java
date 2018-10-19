package nous2.mediatheque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.FilmDTO;
import nous2.mediatheque.entities.Film;
import nous2.mediatheque.repositories.*;

@Service
@PreAuthorize("isAuthenticated()")
public class FilmService implements IFilmService {

    private final IFilmRepository filmRepository;

    private final IFilmJpaRepository filmJpaRepository;

    @Autowired
    protected FilmService(IFilmRepository filmRepository,
	    IFilmJpaRepository filmJpaRepository) {
	this.filmRepository = filmRepository;
	this.filmJpaRepository = filmJpaRepository;
    }

    @Override
    public Film findById(Long id) {
	Optional<Film> optional = filmJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public void save(Film film) {
	filmJpaRepository.save(film);
    }

    @Override
    public List<FilmDTO> findAllAsDTO(AppLanguage lang) {
	return filmRepository.findAllAsDTO(lang);
    }
}
