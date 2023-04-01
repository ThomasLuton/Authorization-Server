package co.simplon.autorizationServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig {

    // LIVE CODING POUR TOUTE CETTE CLASSE

    @Value("${itschool.auth.rounds}")
    private int rounds;
    @Value("${itschool.auth.issuer}")
    private String issuer;
    @Value("${itschool.auth.secret}")
    private String secret;
    @Value("${itschool.auth.tokenExpiration}")
    private long tokenExpiration;

    @Bean
    public AuthHelper authHelpers() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	PasswordEncoder encoder = new BCryptPasswordEncoder(
		rounds);
	return new AuthHelper.Builder().issuer(issuer)
		.expiration(tokenExpiration)
		.algorithm(algorithm)
		.passwordEncoder(encoder).build();
    }
}