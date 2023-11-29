package by.rolles.sensorsmonitor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class SensorDto implements Serializable {

    private String idSensor;

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String model;

    @NotNull
    private Integer rangeFrom;

    @NotNull
    private Integer rangeTo;

    @NotNull
    private TypeDto type;

    @NotNull
    private UnitDto unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;
}