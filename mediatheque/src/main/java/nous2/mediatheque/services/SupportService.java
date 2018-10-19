package nous2.mediatheque.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nous2.mediatheque.AppLanguage;
import nous2.mediatheque.dto.SupportDTO;
import nous2.mediatheque.repositories.ISupportRepository;

@Service
public class SupportService implements ISupportService {

    private final ISupportRepository supportRepository;

    @Autowired
    protected SupportService(ISupportRepository supportRepository) {
	this.supportRepository = supportRepository;
    }

    @Override
    public Set<SupportDTO> findAllAsDTO(AppLanguage lang) {
	return supportRepository.findAllAsDTO(lang);
    }
}
