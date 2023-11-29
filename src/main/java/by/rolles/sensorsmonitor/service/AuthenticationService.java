package by.rolles.sensorsmonitor.service;

import by.rolles.sensorsmonitor.dto.AuthenticationDto;
import by.rolles.sensorsmonitor.dto.TokenDto;
import by.rolles.sensorsmonitor.entity.User;
import by.rolles.sensorsmonitor.exception.UserValidateException;
import by.rolles.sensorsmonitor.repository.RoleUserRepository;
import by.rolles.sensorsmonitor.repository.UserRepository;
import by.rolles.sensorsmonitor.security.JwtProvider;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleUserRepository roleUserRepository;
    private final JwtProvider jwtProvider;
    private final ModelMapper modelMapper;

    public ResponseEntity<?> login(AuthenticationDto authenticationDto) throws UserValidateException {
        Optional<User> userOptional = userRepository.findByLogin(authenticationDto.getLogin());
        if (userOptional.isEmpty()) throw new UserValidateException("The user or password is incorrect");
        if (BCrypt.checkpw(authenticationDto.getPassword(), userOptional.get().getPassword()))
            return ResponseEntity.ok().body(
                    TokenDto.builder()
                            .token(jwtProvider.createToken(authenticationDto.getLogin()))
                            .build());
        else throw new UserValidateException("The user or password is incorrect");
    }

    public ResponseEntity<?> registration(AuthenticationDto authenticationDto) throws UserValidateException {
        Optional<User> userOptional = userRepository.findByLogin(authenticationDto.getLogin());
        if (userOptional.isPresent()) throw new UserValidateException("Login has already been used");
        User user = modelMapper.map(authenticationDto, User.class);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
        user.setRole(roleUserRepository.findByValue("ROLE_USER"));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
