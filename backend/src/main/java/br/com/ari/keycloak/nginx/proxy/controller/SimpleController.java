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
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "I didn't fall down. I did attack the floor, though.",
            "Come over to the dark side…we’ve got candy.",
            "I don’t suffer from insanity, I enjoy every minute of it.",
            "I like to be an optimist. It pisses people off.",
            "He who wakes up early, yawns all day long."
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
