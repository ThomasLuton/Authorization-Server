package co.simplon.authorizationServer;

import java.util.ArrayList;

public class Database {

    private static final ArrayList<Account> ACCOUNTS = new ArrayList<>();

    public static void save(Account account) {
	ACCOUNTS.add(account);
    }

    public static Account getByIdentifier(
	    String identifier) {
	Account result = null;
	for (Account account : ACCOUNTS) {
	    String accountIdentifier = account
		    .getIdentifier();
	    if (accountIdentifier.equals(identifier)) {
		result = account;
		break;
	    }
	}
	return result;
    }

}
