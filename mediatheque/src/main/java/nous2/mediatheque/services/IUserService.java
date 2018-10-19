package nous2.mediatheque.services;

import java.util.List;

import nous2.mediatheque.dto.UserDTO;
import nous2.mediatheque.entities.User;

public interface IUserService {

    public void save(User user);

    public boolean validateEmailAndPseudo(User user);

    public User findById(Long id);

    public List<UserDTO> findAllAsDTO();
}
