package by.rolles.sensorsmonitor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sm_unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unit", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false, length = 25)
    private String value;

}