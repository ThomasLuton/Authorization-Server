package co.simplon.authorizationServer;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

public class AuthHelper {

    // LIVE CODING
    // field => issuer, expiration, algo, encoder
    // constructor with builder
    // method => encode, matches, createJWT

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
