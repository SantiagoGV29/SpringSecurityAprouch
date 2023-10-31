package io.jwttry.my_app.repos;

import io.jwttry.my_app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNameIgnoreCase(String name);
    User findByUsernameIgnoreCase(String username);
    boolean existsByEmailIgnoreCase(String email);

}
