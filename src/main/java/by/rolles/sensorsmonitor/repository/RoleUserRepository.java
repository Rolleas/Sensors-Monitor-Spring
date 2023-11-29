package by.rolles.sensorsmonitor.repository;

import by.rolles.sensorsmonitor.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {

    RoleUser findByValue(String value);
}