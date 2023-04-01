package co.simplon.authorizationServer;

public class Credentials {

    private String identifier;
    private String password;

    public Credentials() {
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

    @Override
    public String toString() {
	return "{identifier=" + identifier
		+ ", password={protected}";
    }

}
