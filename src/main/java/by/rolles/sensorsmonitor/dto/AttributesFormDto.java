package by.rolles.sensorsmonitor.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AttributesFormDto {

    private List<TypeDto> types;
    private List<UnitDto> units;
}
