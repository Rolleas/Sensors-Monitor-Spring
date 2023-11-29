package by.rolles.sensorsmonitor.repository;

import by.rolles.sensorsmonitor.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {
}