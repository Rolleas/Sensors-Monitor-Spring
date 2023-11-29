package by.rolles.sensorsmonitor.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class FilterDto {

    private String keyword;

    @NotNull
    @Min(1)
    private Integer page;
}
