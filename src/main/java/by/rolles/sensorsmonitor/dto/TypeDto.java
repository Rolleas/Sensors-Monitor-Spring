package by.rolles.sensorsmonitor.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TypeDto implements Serializable {

    @NotNull
    private Integer id;
    private String value;
}