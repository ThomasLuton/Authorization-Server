package co.simplon.autorizationServer;

import java.time.Instant;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthHelper {

    // LIVE CODING

    private final String issuer;
    private final long expiration;
    private final Algorithm algorithm;
    private final PasswordEncoder encoder;

    public AuthHelper(Builder builder) {
	this.issuer = builder.issuer;
	this.algorithm = builder.algorithm;
	this.encoder = builder.passwordEncoder;
	this.expiration = builder.expiration;
    }

    public String encode(String password) {
	return encoder.encode(password);
    }

    public Boolean matches(String candidate, String hash) {
	return encoder.matches(candidate, hash);
    }

    public String createJWT(List<String> roles,
	    String name) {
	Instant now = Instant.now();
	Instant exp = now.plusSeconds(expiration);
	String[] rolesAsArray = toStringArray(roles);
	return JWT.create().withIssuer(issuer)
		.withSubject(name).withIssuedAt(now)
		.withExpiresAt(exp)
		.withArrayClaim("roles", rolesAsArray)
		.sign(algorithm);
    }

    public String[] toStringArray(List<String> list) {
	String[] result = new String[list.size()];

	for (int i = 0; i < list.size(); i++) {
	    result[i] = list.get(i);
	}

	return result;
    }

    public static class Builder {
	private String issuer;
	private long expiration;
	private Algorithm algorithm;
	private PasswordEncoder passwordEncoder;

	public Builder() {

	}

	public Builder issuer(String issuer) {
	    this.issuer = issuer;
	    return this;
	}

	public Builder expiration(long expiration) {
	    this.expiration = expiration;
	    return this;
	}

	public Builder algorithm(Algorithm algorithm) {
	    this.algorithm = algorithm;
	    return this;
	}

	public Builder passwordEncoder(
		PasswordEncoder passwordEncoder) {
	    this.passwordEncoder = passwordEncoder;
	    return this;
	}

	public AuthHelper build() {
	    return new AuthHelper(this);
	}
    }
}
