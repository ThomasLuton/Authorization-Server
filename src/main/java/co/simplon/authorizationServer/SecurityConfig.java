package co.simplon.authorizationServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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
}