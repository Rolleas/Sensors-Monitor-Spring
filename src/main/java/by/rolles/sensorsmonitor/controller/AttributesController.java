package by.rolles.sensorsmonitor.controller;

import by.rolles.sensorsmonitor.service.AttributesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attributes/user")
@RequiredArgsConstructor
public class AttributesController {

    private final AttributesService attributesService;

    @GetMapping
    public ResponseEntity<?> getAttributes() {
        return ResponseEntity.ok().body(attributesService.get());
    }
}
