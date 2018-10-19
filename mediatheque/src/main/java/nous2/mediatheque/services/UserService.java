package nous2.mediatheque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nous2.mediatheque.dto.UserDTO;
import nous2.mediatheque.entities.User;
import nous2.mediatheque.repositories.*;

@Service
public class UserService implements IUserService {

    private final IUserJpaRepository userJpaRepository;

    private final IUserRepository userRepository;

    @Autowired
    protected UserService(IUserJpaRepository userJpaRepository,
	    IUserRepository userRepository) {
	this.userJpaRepository = userJpaRepository;
	this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
	encodePassword(user);
	userJpaRepository.save(user);
    }

    private static void encodePassword(User user) {
	String rawPassword = user.getPassword();
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String encodedPassword = encoder.encode(rawPassword);
	user.setPassword(encodedPassword);
    }

    @Override
    public boolean validateEmailAndPseudo(User user) {
	Long id = user.getId();
	String email = user.getEmail();
	String pseudo = user.getPseudo();
	if (id == null) { // create
	    return !userJpaRepository.existsByEmailIgnoreCase(email)
		    && !userJpaRepository.existsByPseudoIgnoreCase(pseudo);
	}
	return !userJpaRepository.existsByEmailIgnoreCaseAndIdNot(email, id);
	// && !userJpaRepository.existsByPseudoIgnoreCaseAndIdNot(pseudo,
	// id); // update
    }

    @Override
    public User findById(Long id) {
	Optional<User> optional = userJpaRepository.findById(id);
	return optional.get();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDTO> findAllAsDTO() {
	return userRepository.findAllAsDTO();
    }
}
