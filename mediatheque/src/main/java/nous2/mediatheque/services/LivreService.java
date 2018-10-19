package nous2.mediatheque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import nous2.mediatheque.dto.LivreDTO;
import nous2.mediatheque.entities.Livre;
import nous2.mediatheque.repositories.*;

@Service
@PreAuthorize("isAuthenticated()")
public class LivreService implements ILivreService {

    private final ILivreRepository livreRepository;

    private final ILivreJpaRepository livreJpaRepository;

    @Autowired
    protected LivreService(ILivreRepository livreRepository,
	    ILivreJpaRepository livreJpaRepository) {
	this.livreRepository = livreRepository;
	this.livreJpaRepository = livreJpaRepository;
    }

    @Override
    public Livre findById(Long id) {
	Optional<Livre> optional = livreJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public void save(Livre livre) {
	livreJpaRepository.save(livre);
    }

    @Override
    public List<LivreDTO> findAllAsDTO() {
	return livreRepository.findAllAsDTO();
    }
}
