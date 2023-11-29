package by.rolles.sensorsmonitor.specification;


import by.rolles.sensorsmonitor.entity.Sensor;
import by.rolles.sensorsmonitor.entity.Type;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class SensorSpecifications {

    public static Specification<Sensor> search(String keyword) {
        return (root, query, builder) -> {
            if (keyword == null || keyword.isEmpty()) return null;
            String pattern = "%" + keyword.toLowerCase() + "%";
            return builder.or(
                    builder.like(builder.lower(root.get("idSensor")), pattern),
                    builder.like(builder.lower(root.get("name")), pattern),
                    builder.like(builder.lower(root.get("model")), pattern),
                    builder.like(builder.lower(root.get("location")), pattern),
                    builder.like(builder.lower(root.get("description")), pattern),
                    builder.like(builder.lower(root.join("type", JoinType.INNER).get("value")), pattern),
                    builder.like(builder.lower(root.join("unit", JoinType.INNER).get("value")), pattern)
            );
        };
    }

}
