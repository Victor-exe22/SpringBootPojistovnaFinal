package cz.itnetwork.springpojistovna.data.repositories;

import cz.itnetwork.springpojistovna.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
