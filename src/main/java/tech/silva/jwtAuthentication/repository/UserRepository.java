package tech.silva.jwtAuthentication.repository;

import org.springframework.data.repository.CrudRepository;
import tech.silva.jwtAuthentication.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUsername(String username);
}
