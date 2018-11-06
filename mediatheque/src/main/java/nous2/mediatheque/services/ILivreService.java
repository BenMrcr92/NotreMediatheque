package nous2.mediatheque.services;

import java.util.List;

import nous2.mediatheque.dto.LivreDTO;
import nous2.mediatheque.entities.Livre;

public interface ILivreService {

    public Livre findById(Long id);

    public void save(Livre livre);

    public List<LivreDTO> findAllAsDTO();

    public String deleteById(Long id);
}
