package nous2.mediatheque.services;

import java.util.List;

import nous2.mediatheque.dto.JeuDTO;
import nous2.mediatheque.entities.Jeu;

public interface IJeuService {

    public Jeu findById(Long id);

    public void save(Jeu jeu);

    public List<JeuDTO> findAllAsDTO();
}
