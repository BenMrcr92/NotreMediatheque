package nous2.mediatheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import nous2.mediatheque.Principal;
import nous2.mediatheque.entities.User;
import nous2.mediatheque.repositories.IUserJpaRepository;

@Service
public class LoginService implements ILoginService {

    private final IUserJpaRepository userJpaRepository;

    @Autowired
    protected LoginService(IUserJpaRepository userJpaRepository) {
	this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
	User user = userJpaRepository.findByPseudo(username);
	if (user == null) {
	    user = userJpaRepository.findByEmail(username);
	    if (user == null) {
		throw new UsernameNotFoundException(
			"No user found with username: " + username);
	    }
	}
	return new Principal(user);
    }
}
