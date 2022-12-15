package br.com.ari.keycloak.nginx.proxy.controller;

import br.com.ari.keycloak.nginx.proxy.dto.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private static final String[] MESSAGES = {
            "Hello from backend!",
            "Meu nome é Ari, não tô nem aí!",
            "Bora Bill!",
            "Imagine uma nova história para sua vida e acredite nela.",
            "Tente mover o mundo – o primeiro passo será mover a si mesmo.",
            "Quando vires um homem bom, tenta imitá-lo; quando vires um homem mau, examina-te a ti mesmo."
    };

    @GetMapping("/message")
    public Message getMessage() {
        return new Message(getRandomMessage());
    }

    private String getRandomMessage() {
        int index = ThreadLocalRandom.current().nextInt(0, MESSAGES.length);
        return MESSAGES[index];
    }

}
