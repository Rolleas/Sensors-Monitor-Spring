package by.rolles.sensorsmonitor.service;

import by.rolles.sensorsmonitor.dto.AttributesFormDto;
import by.rolles.sensorsmonitor.dto.TypeDto;
import by.rolles.sensorsmonitor.dto.UnitDto;
import by.rolles.sensorsmonitor.repository.TypeRepository;
import by.rolles.sensorsmonitor.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttributesService {

    private final TypeRepository typeRepository;
    private final UnitRepository unitRepository;

    private final ModelMapper modelMapper;
    @Cacheable("attributesCache")
    public AttributesFormDto get() {
        return AttributesFormDto.builder()
                .types(typeRepository.findAll().stream().map(x -> modelMapper.map(x, TypeDto.class)).collect(Collectors.toList()))
                .units(unitRepository.findAll().stream().map(x -> modelMapper.map(x, UnitDto.class)).collect(Collectors.toList()))
                .build();
    }
}
