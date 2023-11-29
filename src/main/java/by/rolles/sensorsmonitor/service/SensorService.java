package by.rolles.sensorsmonitor.service;

import by.rolles.sensorsmonitor.dto.FilterDto;
import by.rolles.sensorsmonitor.dto.PageDto;
import by.rolles.sensorsmonitor.dto.SensorDto;
import by.rolles.sensorsmonitor.entity.Sensor;
import by.rolles.sensorsmonitor.entity.Type;
import by.rolles.sensorsmonitor.entity.Unit;
import by.rolles.sensorsmonitor.exception.SensorValidateException;
import by.rolles.sensorsmonitor.repository.SensorRepository;
import by.rolles.sensorsmonitor.repository.TypeRepository;
import by.rolles.sensorsmonitor.repository.UnitRepository;
import by.rolles.sensorsmonitor.specification.SensorSpecifications;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final TypeRepository typeRepository;
    private final UnitRepository unitRepository;
    private final ModelMapper modelMapper;

    @Cacheable("sensorCache")
    public ResponseEntity<?> getByPage(FilterDto filterDto) {
        Page<Sensor> page = sensorRepository.findAll(
                SensorSpecifications.search(filterDto.getKeyword()),
                PageRequest.of(filterDto.getPage() - 1, 4));
        PageDto result = PageDto.builder()
                .maxPage(page.getTotalPages())
                .totalContent(page.getTotalElements())
                .data(page.stream().map(x -> modelMapper.map(x, SensorDto.class)).collect(Collectors.toList()))
                .build();
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    public ResponseEntity<?> save(SensorDto sensorDto) throws SensorValidateException {
        Sensor sensor = modelMapper.map(sensorDto, Sensor.class);
        if (sensorDto.getRangeFrom() > sensor.getRangeTo()) throw new SensorValidateException("Range from more range to");
        if (sensorDto.getIdSensor() != null) {
            Optional<Sensor> optionalSensor = sensorRepository.findById(sensorDto.getIdSensor());
            if (optionalSensor.isEmpty()) throw new SensorValidateException("Sensor not found");
        } else {
            Optional<Type> typeOptional = typeRepository.findById(sensorDto.getType().getId());
            if (typeOptional.isEmpty()) throw new SensorValidateException("Type not found");
            Optional<Unit> unitOptional = unitRepository.findById(sensorDto.getUnit().getId());
            if (unitOptional.isEmpty()) throw new SensorValidateException("Unit not found");
            sensor.setUnit(unitOptional.get());
            sensor.setType(typeOptional.get());
        }
        sensorRepository.save(sensor);
        return ResponseEntity.ok().build();
    }

    public void remove(String uuid) {
        sensorRepository.deleteById(uuid);
    }

    public ResponseEntity<?> getById(String uuid) throws SensorValidateException {
        Optional<Sensor> sensorOptional = sensorRepository.findById(uuid);
        if (sensorOptional.isEmpty()) throw new SensorValidateException("Sensor not found");
        return ResponseEntity.ok().body(modelMapper.map(sensorOptional.get(), SensorDto.class));
    }
}
