package by.rolles.sensorsmonitor.service;


import by.rolles.sensorsmonitor.entity.User;
import by.rolles.sensorsmonitor.repository.UserRepository;
import by.rolles.sensorsmonitor.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByLogin(login);
        return userOptional.map(CustomUserDetails::fromUserEntityToCustomUserDetails).orElse(null);
    }
}