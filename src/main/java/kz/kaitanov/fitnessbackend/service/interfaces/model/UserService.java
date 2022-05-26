package kz.kaitanov.fitnessbackend.service.interfaces.model;

import kz.kaitanov.fitnessbackend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends AbstractService<User, Long>, UserDetailsService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
