package nous2.mediatheque.services;

import java.util.Set;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.SupportDTO;

public interface ISupportService {

    public Set<SupportDTO> findAllAsDTO(AppLanguage lang);
}
