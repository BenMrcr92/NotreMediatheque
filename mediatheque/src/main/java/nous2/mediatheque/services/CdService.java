package nous2.mediatheque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import nous2.mediatheque.dto.CdDTO;
import nous2.mediatheque.entities.Cd;
import nous2.mediatheque.repositories.*;

@Service
@PreAuthorize("isAuthenticated()")
public class CdService implements ICdService {

    private final ICdRepository cdRepository;

    private final ICdJpaRepository cdJpaRepository;

    @Autowired
    protected CdService(ICdRepository cdRepository,
	    ICdJpaRepository cdJpaRepository) {
	this.cdRepository = cdRepository;
	this.cdJpaRepository = cdJpaRepository;
    }

    @Override
    public Cd findById(Long id) {
	Optional<Cd> optional = cdJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public void save(Cd cd) {
	cdJpaRepository.save(cd);
    }

    @Override
    public List<CdDTO> findAllAsDTO() {
	return cdRepository.findAllAsDTO();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @Override
    public void deleteById(Long id) {
	cdJpaRepository.deleteById(id);
    }
}
