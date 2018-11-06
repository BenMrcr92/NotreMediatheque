package nous2.mediatheque.services;

import java.util.List;

import nous2.mediatheque.dto.CdDTO;
import nous2.mediatheque.entities.Cd;

public interface ICdService {

    public Cd findById(Long id);

    public void save(Cd cd);

    public List<CdDTO> findAllAsDTO();

    public void deleteById(Long id);
}
