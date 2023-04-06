package co.simplon.authorizationServer;

public interface AuthService {

    public void signUp(Credentials inputs);

    public TokenInfo signIn(Credentials inputs);

}
