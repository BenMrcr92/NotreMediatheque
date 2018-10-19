package nous2.mediatheque.repositories;

import java.util.List;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.FilmDTO;

public interface IFilmRepository {

    List<FilmDTO> findAllAsDTO(AppLanguage lang);
}
