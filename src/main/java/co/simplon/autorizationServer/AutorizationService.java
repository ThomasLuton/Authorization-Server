package co.simplon.autorizationServer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AutorizationService {

    // LIVE CODING

    private AuthHelper authHelper;

    public AutorizationService(AuthHelper authHelper) {
	this.authHelper = authHelper;
    }

    public void signUp(Credentials inputs) {
	Account account = new Account();
	account.setIdentifier(inputs.getIdentifier());

	String password = inputs.getPassword();
	String hashPassword = authHelper.encode(password);
	account.setPassword(hashPassword);

	List<String> roles = new ArrayList<>();
	roles.add("USER");
	account.setRoles(roles);

	Database.save(account);
    }

    public TokenInfo signIn(Credentials inputs) {

	String identifer = inputs.getIdentifier();
	String candidate = inputs.getPassword();

	Account user = Database.getByIdentifier(identifer);

	if (user != null) {
	    String hash = user.getPassword();
	    boolean match = authHelper.matches(candidate,
		    hash);

	    if (match) {
		List<String> roles = user.getRoles();
		TokenInfo tokenInfo = new TokenInfo();
		String token = authHelper.createJWT(roles,
			user.getIdentifier());
		tokenInfo.setToken(token);
		tokenInfo.setRoles(roles);
		return tokenInfo;
	    } else {
		throw new BadCredentialsException(
			"Wrong credential");
	    }
	} else {
	    throw new BadCredentialsException(
		    "Wrong credential");
	}
    }

}
