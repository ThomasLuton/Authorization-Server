package co.simplon.authorizationServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /*
     * Autowired permet de faire de l'injection de dépendance. Il a le même effet
     * que l'injection via constructeur. Car autowired injecte depuis le champ, il
     * est impossible de déclarer un champ final sans lui affecter de valeur. Bonne
     * pratique déclarer les injections de dépendances par constructeur et les
     * rendre final (évite les réaffectations accidentelles)
     */
    @Autowired
    private AuthService service;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(@RequestBody Credentials inputs) {
	service.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public TokenInfo signIn(
	    @RequestBody Credentials inputs) {
	return service.signIn(inputs);
    }

}
