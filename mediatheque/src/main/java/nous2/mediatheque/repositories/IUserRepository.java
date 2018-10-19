package nous2.mediatheque.repositories;

import java.util.List;

import nous2.mediatheque.dto.UserDTO;

public interface IUserRepository {

    public List<UserDTO> findAllAsDTO();
}
