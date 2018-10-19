package nous2.mediatheque.services;

import org.springframework.security.core.userdetails.*;

public interface ILoginService extends UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username);
}
