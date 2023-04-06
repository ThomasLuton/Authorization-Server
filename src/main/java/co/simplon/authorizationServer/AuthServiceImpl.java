package co.simplon.authorizationServer;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    // Implementation sign Up, sign in
    @Override
    public void signUp(Credentials inputs) {

    }

    @Override
    public TokenInfo signIn(Credentials inputs) {
	return null;
    }

}
