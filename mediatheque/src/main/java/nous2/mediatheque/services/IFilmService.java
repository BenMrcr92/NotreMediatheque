package nous2.mediatheque.services;

import java.util.List;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.FilmDTO;
import nous2.mediatheque.entities.Film;

public interface IFilmService {

    public Film findById(Long id);

    public void save(Film film);

    public List<FilmDTO> findAllAsDTO(AppLanguage lang);

    public void deleteById(Long id);
}
