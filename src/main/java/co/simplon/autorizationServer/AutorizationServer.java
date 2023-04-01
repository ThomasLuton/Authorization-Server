package co.simplon.autorizationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AutorizationServer {

    public static void main(String[] args) {
	SpringApplication.run(
		AutorizationServer.class,
		args);
    }

}
