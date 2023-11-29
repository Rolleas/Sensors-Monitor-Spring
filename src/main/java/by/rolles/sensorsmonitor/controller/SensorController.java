package by.rolles.sensorsmonitor.controller;

import by.rolles.sensorsmonitor.dto.FilterDto;
import by.rolles.sensorsmonitor.dto.SensorDto;
import by.rolles.sensorsmonitor.exception.SensorValidateException;
import by.rolles.sensorsmonitor.exception.UserValidateException;
import by.rolles.sensorsmonitor.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/user/list")
    public ResponseEntity<?> getByPage(@Validated @RequestBody FilterDto filterDto) {
        return sensorService.getByPage(filterDto);
    }

    @PostMapping("/admin/save")
    public ResponseEntity<?> save(@Validated @RequestBody SensorDto sensorDto) throws SensorValidateException {
        return sensorService.save(sensorDto);
    }

    @DeleteMapping("/admin/remove")
    private void remove(@RequestParam(name = "id") String uuid) {
        sensorService.remove(uuid);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getById(@RequestParam(name = "id") String uuid) throws SensorValidateException {
        return sensorService.getById(uuid);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotFoundException() {
        return new ResponseEntity<>("Required request body is missing", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorValidateException.class)
    public ResponseEntity<String> handleNotFoundException(SensorValidateException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
