package co.simplon.authorizationServer;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // LIVE CODING

    private AuthHelper authHelper;

    public AuthService(AuthHelper authHelper) {
	this.authHelper = authHelper;
    }

    public void signUp(Credentials inputs) {

    }

    public TokenInfo signIn(Credentials inputs) {
	return null;
    }

}
