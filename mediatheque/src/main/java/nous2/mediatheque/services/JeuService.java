package nous2.mediatheque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import nous2.mediatheque.dto.JeuDTO;
import nous2.mediatheque.entities.Jeu;
import nous2.mediatheque.repositories.*;

@Service
@PreAuthorize("isAuthenticated()")
public class JeuService implements IJeuService {

    private final IJeuRepository jeuRepository;

    private final IJeuJpaRepository jeuJpaRepository;

    @Autowired
    protected JeuService(IJeuRepository jeuRepository,
	    IJeuJpaRepository jeuJpaRepository) {
	this.jeuRepository = jeuRepository;
	this.jeuJpaRepository = jeuJpaRepository;
    }

    @Override
    public Jeu findById(Long id) {
	Optional<Jeu> optional = jeuJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    public void save(Jeu jeu) {
	jeuJpaRepository.save(jeu);
    }

    @Override
    public List<JeuDTO> findAllAsDTO() {
	return jeuRepository.findAllAsDTO();
    }
}
