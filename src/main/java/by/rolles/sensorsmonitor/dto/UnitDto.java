package by.rolles.sensorsmonitor.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UnitDto implements Serializable {

    @NotNull
    private Integer id;
    private String value;
}