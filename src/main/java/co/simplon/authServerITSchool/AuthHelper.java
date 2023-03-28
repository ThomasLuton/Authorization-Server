package co.simplon.authServerITSchool;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthHelper {

    // LIVE CODING

    private final String issuer;
    private final long expiration;
    private final Algorithm algorithm;
    private final PasswordEncoder encoder;

    public AuthHelper(String issuer, long expiration,
	    Algorithm algorithm, PasswordEncoder encoder) {
	this.issuer = issuer;
	this.algorithm = algorithm;
	this.encoder = encoder;
	this.expiration = expiration;
    }

    public String encode(String password) {
	return encoder.encode(password);
    }

    public Boolean matches(String candidate, String hash) {
	return encoder.matches(candidate, hash);
    }

    public String createJWT(String[] roles, String name) {
	Instant now = Instant.now();
	Instant exp = now.plusSeconds(expiration);
	return JWT.create().withIssuer(issuer)
		.withSubject(name).withIssuedAt(now)
		.withExpiresAt(exp)
		.withArrayClaim("roles", roles)
		.sign(algorithm);
    }
}
