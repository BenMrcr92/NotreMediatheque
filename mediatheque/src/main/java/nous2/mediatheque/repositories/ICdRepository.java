package nous2.mediatheque.repositories;

import java.util.List;

import nous2.mediatheque.dto.CdDTO;

public interface ICdRepository {

    List<CdDTO> findAllAsDTO();
}
