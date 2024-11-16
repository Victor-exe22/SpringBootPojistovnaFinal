package cz.itnetwork.springpojistovna.models.services;

import cz.itnetwork.springpojistovna.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create(UserDTO user, boolean isAdmin);
}
