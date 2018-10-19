package nous2.mediatheque.repositories;

import java.util.List;

import nous2.mediatheque.dto.LivreDTO;

public interface ILivreRepository {

    List<LivreDTO> findAllAsDTO();
}
