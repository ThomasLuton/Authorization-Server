package co.simplon.authorizationServer;

import java.util.List;

public class Account {

    private String identifier;
    private String password;
    private List<String> roles;

    public Account() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getIdentifier() {
	return identifier;
    }

    public void setIdentifier(String identifier) {
	this.identifier = identifier;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return "{identifier=" + identifier + ", password="
		+ password + ", roles=" + roles + "}";
    }

}
