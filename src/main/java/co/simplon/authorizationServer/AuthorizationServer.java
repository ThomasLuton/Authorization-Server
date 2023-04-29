package co.simplon.authorizationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AuthorizationServer {

    public static void main(String[] args) {

	SpringApplication.run(AuthorizationServer.class,
		args);
    }

}
