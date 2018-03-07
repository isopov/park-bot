package ru.mail.park.chatbot.parkbot;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.BotSession;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private BotSession session;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null) {
            System.out.print(message.getFrom().getUserName());
            System.out.print(" ");
            System.out.println(message.getText());

        }
    }

    @Override
    public String getBotUsername() {
        // TODO config
        return "TODO";
    }

    @Override
    public String getBotToken() {
        // TODO config
        return "TODO";
    }

    @PostConstruct
    public void setup() throws TelegramApiRequestException {
        session = new TelegramBotsApi().registerBot(this);
    }

    @PreDestroy
    public void tearDown() {
        session.stop();
    }

}
