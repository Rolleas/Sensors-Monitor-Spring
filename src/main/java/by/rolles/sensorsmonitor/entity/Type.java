package by.rolles.sensorsmonitor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sm_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false, length = 50)
    private String value;

}