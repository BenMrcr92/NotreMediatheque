package nous2.mediatheque.repositories;

import java.util.List;

import nous2.mediatheque.dto.JeuDTO;

public interface IJeuRepository {

    List<JeuDTO> findAllAsDTO();
}
