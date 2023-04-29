package co.simplon.authorizationServer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthHelper authHelper;

    public AuthServiceImpl(AuthHelper authHelper) {
	this.authHelper = authHelper;
    }

    // Implementation sign Up, sign in
    @Override
    public void signUp(Credentials inputs) {
	Account account = new Account();
	account.setIdentifier(inputs.getIdentifier());

	String hashPassword = authHelper
		.encode(inputs.getPassword());
	account.setPassword(hashPassword);

	List<String> roles = new ArrayList<String>();
	/*
	 * Attention, pour le bien de l'exercice le rôle est attribué grâce à
	 * l'identifier. Evidemment c'est une mauvaise pratique, Il est préférable
	 * d'avoir un rôle attribué par défaut et de donner la possibilité de le
	 * modifier pour un utilisateur ayant un rôle adapté.
	 */
	if (inputs.getIdentifier()
		.equalsIgnoreCase("admin")) {
	    roles.add("ROLE_ADMIN");
	} else if (inputs.getIdentifier()
		.equalsIgnoreCase("both")) {
	    roles.add("ROLE_ADMIN");
	    roles.add("ROLE_USER");
	} else {
	    roles.add("ROLE_USER");
	}
	account.setRoles(roles);

	Database.save(account);

	System.out.println(account.toString());

    }

    @Override
    public TokenInfo signIn(Credentials inputs) {
	String identifier = inputs.getIdentifier();
	String candidate = inputs.getPassword();

	Account account = Database
		.getByIdentifier(identifier);

	if (account != null) {
	    boolean match = authHelper.matches(candidate,
		    account.getPassword());
	    if (match) {
		String name = account.getIdentifier();
		List<String> roles = account.getRoles();
		String token = authHelper.createJWT(roles,
			name);

		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setToken(token);
		tokenInfo.setRoles(roles);

		return tokenInfo;
	    } else {
		throw new BadCredentialsException(
			"Wrong credentials");
	    }
	} else {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}
    }

}
