package by.rolles.sensorsmonitor.controller;

import by.rolles.sensorsmonitor.dto.AuthenticationDto;
import by.rolles.sensorsmonitor.exception.UserValidateException;
import by.rolles.sensorsmonitor.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Validated @RequestBody AuthenticationDto authenticationDto) throws UserValidateException {
        return authenticationService.login(authenticationDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody AuthenticationDto authenticationDto) throws UserValidateException {
        return authenticationService.registration(authenticationDto);
    }

    @ExceptionHandler(UserValidateException.class)
    public ResponseEntity<String> handleNotFoundException(UserValidateException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
