import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());


    }

    public String getBotUsername() {
        return "MyAmazingBot";
    }

    public String getBotToken() {
        return "817526596:AAHIB9_-KnUhYWhFqdgeXsUo2TdPAzu1AHo";
    }
}


