package ru.mail.park.chatbot.parkbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ParkBotApplication {

    static {
        ApiContext.register(BotSession.class, DefaultBotSession.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ParkBotApplication.class, args);
    }
}
