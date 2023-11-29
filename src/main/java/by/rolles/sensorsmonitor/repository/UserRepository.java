package by.rolles.sensorsmonitor.repository;

import by.rolles.sensorsmonitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByLogin(String login);
}