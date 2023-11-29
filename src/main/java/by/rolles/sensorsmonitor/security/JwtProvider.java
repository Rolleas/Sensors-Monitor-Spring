package by.rolles.sensorsmonitor.security;

import by.rolles.sensorsmonitor.entity.User;
import by.rolles.sensorsmonitor.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final UserRepository userRepository;

    @Value("$(jwt.secret)")
    private String secret;

    public String createToken(String login) {
        long expiration = 3600000 * 1000L;
        Date valid = new Date(new Date().getTime() + expiration);
        Optional<User> userOptional = userRepository.findByLogin(login);
        return userOptional.map(user -> Jwts.builder()
                .setSubject(login)
                .setExpiration(valid)
                .claim("role", user.getRole().getValue())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()).orElse(null);
    }

    public String getLoginFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception ignored) {}
        return false;
    }
}
