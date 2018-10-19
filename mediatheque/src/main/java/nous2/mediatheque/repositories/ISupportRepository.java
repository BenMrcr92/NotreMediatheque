package nous2.mediatheque.repositories;

import java.util.Set;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.SupportDTO;

public interface ISupportRepository {

    public Set<SupportDTO> findAllAsDTO(AppLanguage lang);
}
