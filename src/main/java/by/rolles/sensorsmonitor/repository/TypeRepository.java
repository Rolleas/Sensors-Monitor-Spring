package by.rolles.sensorsmonitor.repository;

import by.rolles.sensorsmonitor.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}