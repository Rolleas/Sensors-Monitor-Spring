package by.rolles.sensorsmonitor.repository;

import by.rolles.sensorsmonitor.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String>, JpaSpecificationExecutor<Sensor> {

}