package co.simplon.authServerITSchool;

import java.util.Arrays;

public class TokenInfo {

    private String token;
    private String[] roles;

    public TokenInfo() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String[] getRoles() {
	return roles;
    }

    public void setRoles(String[] roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", roles="
		+ Arrays.toString(roles) + "}";
    }

}
