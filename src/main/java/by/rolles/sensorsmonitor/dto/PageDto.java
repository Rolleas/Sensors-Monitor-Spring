package by.rolles.sensorsmonitor.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class PageDto implements Serializable {

    private Integer maxPage;
    private Long totalContent;
    private List<SensorDto> data;
}
