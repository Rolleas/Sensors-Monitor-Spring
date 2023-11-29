package by.rolles.sensorsmonitor.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "sm_sensor")
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_sensor", nullable = false, length = 100)
    private String idSensor;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "model", nullable = false, length = 15)
    private String model;

    @Column(name = "range_from", nullable = false)
    private Integer rangeFrom;

    @Column(name = "range_to", nullable = false)
    private Integer rangeTo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "type", nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "unit", nullable = false)
    private Unit unit;

    @Column(name = "location", nullable = false, length = 40)
    private String location;

    @Column(name = "description", length = 200)
    private String description;

}